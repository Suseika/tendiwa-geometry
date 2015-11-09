package org.tendiwa.geometry.continuum.rectangles

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

