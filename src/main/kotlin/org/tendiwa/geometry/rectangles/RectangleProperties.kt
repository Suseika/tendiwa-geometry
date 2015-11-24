package org.tendiwa.geometry.rectangles

import org.tendiwa.geometry.dimensions.Dimension
import org.tendiwa.geometry.points.Point
import org.tendiwa.plane.directions.OrdinalDirection

val Rectangle.maxX: Double
    get() = x + width

val Rectangle.maxY: Double
    get() = y + height

// TODO: Move to RectangleOperations.kt
fun Rectangle.corner(corner: OrdinalDirection): Point {
    return when (corner) {
        OrdinalDirection.NW -> Point(x, y)
        OrdinalDirection.NE -> Point(x + width, y)
        OrdinalDirection.SE -> Point(x + width, y + height)
        OrdinalDirection.SW -> Point(x, y + height)
    }
}

val Rectangle.size: Dimension
    get() = Dimension(width, height)

val Rectangle.start: Point
    get() = Point(x, y)
