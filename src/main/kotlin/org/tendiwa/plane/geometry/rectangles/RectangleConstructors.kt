package org.tendiwa.plane.geometry.rectangles

import org.tendiwa.plane.geometry.dimensions.Dimension
import org.tendiwa.plane.geometry.points.Point

fun Rectangle(start: Point, size: Dimension): Rectangle =
    Rectangle(start.x, start.y, size.width, size.height)

fun rectangleFromRanges(
    minX: Double,
    maxX: Double,
    minY: Double,
    maxY: Double
): Rectangle =
    Rectangle(
        minX,
        maxX - minX,
        minY,
        maxY - minY
    )

val Rectangle.Companion.ANY : Rectangle
    get() = Rectangle(-40.2, -59.0, 89.1, 41.13)

fun SquareAt0(width: Double): Rectangle =
    Rectangle(0.0, 0.0, width, width)
