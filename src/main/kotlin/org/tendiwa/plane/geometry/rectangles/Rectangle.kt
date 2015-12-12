package org.tendiwa.plane.geometry.rectangles

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.polygons.Polygon

/**
 * Axis-parallel rectangle of points in ℝ×ℝ.
 */
data class Rectangle(
    val x: Double,
    val y: Double,
    val width: Double,
    val height: Double
) : Polygon {

    init {
        if (width == 0.0 || height == 0.0) {
            throw IllegalArgumentException(
                "Rectangle can't have width or height == 0.0: rectangle " +
                    "$width×$height"
            )
        }
    }

    override val points =
        listOf(
            Point(x, y),
            Point(maxX, y),
            Point(maxX, maxY),
            Point(x, maxY)
        )
}
