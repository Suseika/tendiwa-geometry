package org.tendiwa.geometry.continuum.segments

import org.tendiwa.geometry.continuum.points.Point
import org.tendiwa.geometry.continuum.shapes.Shape

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
