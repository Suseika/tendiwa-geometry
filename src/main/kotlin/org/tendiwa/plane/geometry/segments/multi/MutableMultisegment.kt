package org.tendiwa.plane.geometry.segments.multi

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.distanceTo
import org.tendiwa.plane.geometry.segments.Segment
import java.util.*

/**
 * @param original The segment to split.
 * @see Multisegment For the explanation of the metaphor of a kebab.
 */
class MutableMultisegment(
    override val original: Segment
) : Multisegment {
    private val intervalsSet =
        TreeSet<Segment>({
            a, b ->
            java.lang.Double.compare(
                a.start.distanceTo(original.start),
                b.start.distanceTo(original.start)
            )
        })
            .apply { add(original) }

    override val subsegments: List<Segment>
        get() = intervalsSet.toList()

    constructor(segment: Segment, cuts: List<Point>) : this(segment) {
        cuts.forEach { add(it) }
    }

    fun add(cut: Point) {
        if (!canCutAtPoint(cut)) {
            throw IllegalArgumentException(
                "Can't split segment $original at point $cut because" +
                    " it is either an endpoint of the segment, or an existing" +
                    " split point"
            )
        }
        intervalWithPoint(cut)
            .apply {
                split(
                    this,
                    Segment(start, cut),
                    Segment(cut, end)
                );
            }
    }

    private fun canCutAtPoint(point: Point) =
        // Doesn't consider the case when a cut is outside the original segment.
        original.start != point
            && original.end != point
            && cuts.all { it != point }

    private fun intervalWithPoint(point: Point): Segment =
        intervalsSet
            .find { s -> isPointInBoundingRectangle(point, s) }
            ?:
            throw IllegalArgumentException(
                "Point $point is not on the original segment $original"
            )

    private fun split(
        interval: Segment,
        firstHalf: Segment,
        secondHalf: Segment
    ) {
        assert(intervalsSet.contains(interval))
        assert(firstHalf.end === secondHalf.start)
        assert(firstHalf.start === interval.start)
        assert(secondHalf.end === interval.end)
        intervalsSet.remove(interval);
        intervalsSet.add(firstHalf);
        intervalsSet.add(secondHalf);
    }
}

private fun isPointInBoundingRectangle(
    point: Point,
    segment: Segment
): Boolean =
    if (segment.start.x != segment.end.x) {
        val minX = Math.min(segment.start.x, segment.end.x);
        val maxX = Math.max(segment.start.x, segment.end.x);
        point.x > minX && point.x < maxX;
    } else {
        val minY = Math.min(segment.start.y, segment.end.y);
        val maxY = Math.max(segment.start.y, segment.end.y);
        point.y > minY && point.y < maxY;
    }
