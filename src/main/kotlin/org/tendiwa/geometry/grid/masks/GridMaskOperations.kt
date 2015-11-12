package org.tendiwa.geometry.grid.masks

import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.tiles.Tile

fun GridMask.contains(tile: Tile): Boolean
    = contains(tile.x, tile.y)

fun GridMask.boundedBy(rectangle: GridRectangle): BoundedGridMask =
    object : BoundedGridMask {
        override val hull = rectangle

        override fun contains(x: Int, y: Int): Boolean =
            this@boundedBy.contains(x, y)
    }
