package org.tendiwa.geometry.grid.gridMasks

import org.tendiwa.geometry.grid.tiles.Tile

/**
 * Grid mask that knows how many tiles it contains.
 */
interface FiniteGridMask : GridMask {

    val tiles: Set<Tile>

    fun forEachTile(operation: (Int, Int)-> Unit) =
        tiles.forEach { operation.invoke(it.x, it.y) }
}
