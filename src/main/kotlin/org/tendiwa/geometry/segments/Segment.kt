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
    init {
        if (start == end) {
            throw IllegalArgumentException(
                "Start can't be equal to end (they're both $start)"
            )
        }
    }
    override val points: List<Point>
        get() = listOf(start, end)

    override val segments: List<Segment>
        get() = listOf(this)
}
