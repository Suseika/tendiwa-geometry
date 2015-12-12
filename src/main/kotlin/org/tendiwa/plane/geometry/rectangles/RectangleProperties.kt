package org.tendiwa.plane.geometry.rectangles

import org.tendiwa.plane.directions.OrdinalDirection
import org.tendiwa.plane.geometry.dimensions.Dimension
import org.tendiwa.plane.geometry.points.Point

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
