package org.tendiwa.geometry.grid.masks.mutable

import org.tendiwa.geometry.grid.tiles.Tile

fun MutableGridMask.add(tile: Tile) {
    this.add(tile.x, tile.y)
}

fun MutableGridMask.remove(tile: Tile) {
    this.remove(tile.x, tile.y)
}
