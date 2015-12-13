package org.tendiwa.plane.geometry.segments.cut

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.segments.Segment

/**
 * [Segment] split into parts with cuts along this segment.
 */
interface CutSegment {
    val originalSegment: Segment

    /**
     * Ordered parts into which the [originalSegment] is split. For each
     * part, if there is a next part, then `next.start === current.end`.
     */
    val parts: List<Segment>

    val cuts: List<Point>
        get() = parts.dropLast(1).map { it.end }

    val hasBeenCut: Boolean
        get() = !cuts.isEmpty()

    fun partWithPoint(point: Point): Segment;
}
