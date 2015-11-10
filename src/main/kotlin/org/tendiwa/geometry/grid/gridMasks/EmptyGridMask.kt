package org.tendiwa.geometry.grid.gridMasks

import org.tendiwa.geometry.grid.tiles.Tile

/**
 * Grid mask with no tiles in it.
 */
class EmptyGridMask : FiniteGridMask {
    override val tiles = emptySet<Tile>()

    override fun contains(x: Int, y: Int): Boolean =
        false
}
