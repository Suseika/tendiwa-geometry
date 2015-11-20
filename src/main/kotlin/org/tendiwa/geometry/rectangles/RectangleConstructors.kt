package org.tendiwa.geometry.rectangles

import org.tendiwa.geometry.Dimension
import org.tendiwa.geometry.points.Point

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

