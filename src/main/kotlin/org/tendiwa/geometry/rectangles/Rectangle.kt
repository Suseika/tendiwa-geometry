package org.tendiwa.geometry.rectangles

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.shapes.Shape

/**
 * Axis-parallel rectangle or points in ℝ×ℝ.
 */
data class Rectangle(
    val x: Double,
    val y: Double,
    val width: Double,
    val height: Double
) : Shape {
    override val points =
        listOf(
            Point(x, y),
            Point(maxX, y),
            Point(maxX, maxY),
            Point(x, maxY)
        )
}
