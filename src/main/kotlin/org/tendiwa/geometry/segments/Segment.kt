package org.tendiwa.geometry.segments

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.shapes.Shape

/**
 * A line segment.
 */
data class Segment(
    val start: Point,
    val end: Point
) : Shape {
    override val points: List<Point>
        get() = listOf(start, end)
}
