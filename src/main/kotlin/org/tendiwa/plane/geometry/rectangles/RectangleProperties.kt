package org.tendiwa.plane.geometry.rectangles

import org.tendiwa.plane.directions.OrdinalDirection
import org.tendiwa.plane.geometry.dimensions.Dimension
import org.tendiwa.plane.geometry.points.Point

// TODO: Move to RectangleOperations.kt
fun Rectangle.corner(corner: OrdinalDirection): Point {
    return when (corner) {
        OrdinalDirection.NW -> Point(x, maxY)
        OrdinalDirection.NE -> Point(maxX, maxY)
        OrdinalDirection.SE -> Point(maxX, y)
        OrdinalDirection.SW -> Point(x, y)
    }
}

val Rectangle.size: Dimension
    get() = Dimension(width, height)

val Rectangle.start: Point
    get() = Point(x, y)

val Rectangle.area: Double
    get() = width * height
