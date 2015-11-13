package org.tendiwa.geometry.continuum.rectangles

import org.tendiwa.geometry.continuum.points.Point
import org.tendiwa.geometry.continuum.shapes.Shape

/**
 * Axis-parallel rectangle or points in ℝ×ℝ.
 */
data class Rectangle(
    val x: Double,
    val y: Double,
    val width: Double,
    val height: Double
) : Shape {
    override fun iterator(): Iterator<Point> =
        listOf(
            Point(x, y),
            Point(maxX, y),
            Point(maxX, maxY),
            Point(x, maxY)
        )
            .iterator()
}
