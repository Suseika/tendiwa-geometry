package org.tendiwa.plane.geometry.segments

import java.util.*

/**
 * Checks line segments for intersection.
 *
 * Algorithm needs O(n) space.
 *
 * Unlike the naive O(n^2) approach, this algorithm runs in O(n*log n) time.
 */
fun Collection<Segment>.areIntersected(): Boolean {
    val events = ArrayList<AlgEvent>()
    for (l in this) {
        events.add(AlgEvent(l, true))
        events.add(AlgEvent(l, false))
    }
    Collections.sort(events)
    val sl = TreeSet(Comparator<Segment> { l1, l2 -> compareLines(l1, l2) })
    for (e in events) {
        if (e.isStart) {
            val nl = e.line
            val above = sl.higher(nl)
            if (above != null) {
                if (linesIntersect(above, nl)) {
                    return true
                }
            }
            val below = sl.lower(nl)
            if (below != null) {
                if (linesIntersect(below, nl)) {
                    return true
                }
            }
            sl.add(nl)
        } else {
            val nl = e.line
            val above = sl.higher(nl)
            val below = sl.lower(nl)
            sl.remove(nl)
            if ((above != null) && (below != null)) {
                if (linesIntersect(above, below)) {
                    return true
                }
            }
        }
    }
    return false
}

private fun linesIntersect(l1: Segment, l2: Segment): Boolean {
    val rx = l1.end.x - l1.start.x
    val ry = l1.end.y - l1.start.y

    val sx = l2.end.x - l2.start.x
    val sy = l2.end.y - l2.start.y

    val rXs = rx * sy - ry * sx
    if (rXs == 0.0) {
        // lines are parallel
        // they may be collinear, but we also consider that case to be
        // non-intersecting.
        return false
    } else {
        val qMpx = l2.start.x - l1.start.x
        val qMpy = l2.start.y - l1.start.y
        val t = (qMpx * sy - qMpy * sx) / rXs
        val q = (qMpx * ry - qMpy * rx) / rXs
        // 1e-10 is needed here, because sometimes floating-point errors creep up when moving the points
        return t > 1e-10 && t < (1 - 1e-10) && q > 1e-10 && q < (1 - 1e-10)
    }
}

fun compareLines(l1: Segment, l2: Segment): Int {
    val r: Int
    // need to handle the case when the line is compared to itself
    // since Segment.equals only uses reference equality,
    // we'll use comparison of two points, to be on the safe side.
    if (l1.start == l2.start && l1.end == l2.end) {
        r = 0
    } else if (l2.start.x == l1.start.x) {
        // if both points start on the same X,
        // line with greater start Y value is above the other line
        if (l2.start.y < l1.start.y) {
            r = 1
        } else if (l2.start.y > l1.start.y) {
            r = -1
        } else {
            // but if the lines both start at the same point ((l1.x1,l1.y1) == (l2.x1,l2.y1)),
            // things get a bit more complicated

            if (l1.start.x == l1.end.x && l2.start.x == l2.end.x) {
                // Both lines are vertical, so we take the one with greater Y2 value to be above the other line
                // This case shouldn't happen in normal practice, but who knows.
                r = if (l1.end.y > l2.end.y) 1 else -1
            } else if (l1.start.x == l1.end.x) {
                // Only the first line is vertical.
                // Since vertical lines always have their Y2 bigger than Y1 (see AlgEvent constructor),
                // we can safely assume that l1 is above l2.
                r = 1
            } else if (l2.start.x == l2.end.x) {
                // Same as above, but for l2.
                r = -1
            } else {
                // Both lines start in the same point, both are not vertical -
                // thus we will need to compute which one climbs faster.
                val dx1 = (l1.end.x - l1.start.x) / (l1.end.y - l1.start.y)
                val dx2 = (l2.end.x - l2.start.x) / (l2.end.y - l2.start.y)
                r = java.lang.Double.compare(dx1, dx2)
            }
        }
    } else if (l2.start.x < l1.start.x) {
        // We need to find the Y coordinate for vertical projection of l1.X1 on l2.
        // If that Y coordinate is smaller than l1.Y1, then l1 is considered to be above l2.
        val px = l2.start.x
        val py = l2.start.y
        val rx = l2.end.x - l2.start.x
        val ry = l2.end.y - l2.start.y
        val y = py + (l1.start.x - px) / rx * ry
        r = if (y < l1.start.y) 1 else -1
    } else {
        // Same as above, only reversed.
        val px = l1.start.x
        val py = l1.start.y
        val rx = l1.end.x - l1.start.x
        val ry = l1.end.y - l1.start.y
        val y = py + (l2.start.x - px) / rx * ry
        r = if (y < l2.start.y) -1 else 1
    }
    return r
}

private class AlgEvent internal constructor(l: Segment, var isStart: Boolean) : Comparable<AlgEvent> {

    internal var line: Segment

    init {
        // ensure proper line direction
        if (l.start.x < l.end.x || (l.start.x == l.end.x && l.start.y < l.end.y)) {
            line = Segment(l.start, l.end)
        } else {
            line = Segment(l.end, l.start)
        }
    }

    private val x: Double
        get() = if (isStart) line.start.x else line.end.x

    private val y: Double
        get() = if (isStart) line.start.y else line.end.y

    override fun compareTo(o: AlgEvent): Int {
        if (this.x < o.x) {
            return -1
        } else if (this.x > o.x) {
            return 1
        } else if (this.y < o.y) {
            return -1
        } else if (this.y > o.y) {
            return 1
        } else {
            return 0
        }
    }
}
