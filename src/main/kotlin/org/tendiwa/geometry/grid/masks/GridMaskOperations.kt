package org.tendiwa.geometry.grid.masks

import org.tendiwa.geometry.grid.tiles.Tile

fun GridMask.contains(tile: Tile): Boolean
    = contains(tile.x, tile.y)

