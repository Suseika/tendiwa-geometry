package org.tendiwa.plane.geometry.rectangles

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.polygons.Polygon
import org.tendiwa.plane.geometry.ranges2d.Range2D

/**
 * Axis-parallel rectangle of points in ℝ×ℝ.
 */
data class Rectangle
/**
 * @param x X coordinate of bottom-left corner.
 * @param y Y coordinate of bottom-right corner.
 * @param width Width.
 * @param height Height.
 */
(
    val x: Double,
    val y: Double,
    val width: Double,
    val height: Double
) : Polygon, Range2D {
    companion object {}

    override val minX: Double
        get() = x

    override val minY: Double
        get() = y

    override val maxX: Double
        get() = x + width

    override val maxY: Double
        get() = y + height

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
