package org.tendiwa.geometry.grid.rectangles

import org.tendiwa.geometry.grid.directions.OrdinalDirection
import org.tendiwa.geometry.grid.tiles.Tile

fun GridRectangle.corner(direction: OrdinalDirection) =
    when (direction) {
        OrdinalDirection.NW -> Tile(x, y)
        OrdinalDirection.NE -> Tile(maxX, y)
        OrdinalDirection.SE -> Tile(maxX, maxY)
        OrdinalDirection.SW -> Tile(x, maxY)
    }

