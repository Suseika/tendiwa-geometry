package org.tendiwa.geometry.segments

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.shapes.SegmentGroup

/**
 * A line segment.
 */
data class Segment(
    val start: Point,
    val end: Point
) : SegmentGroup {
    override val points: List<Point>
        get() = listOf(start, end)

    override val segments: List<Segment>
        get() = listOf(this)
}
