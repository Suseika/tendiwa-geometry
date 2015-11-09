package org.tendiwa.geometry.grid.gridMasks

import org.tendiwa.geometry.grid.tiles.Tile

interface FiniteGridMask : GridMask {
    val tiles: Set<Tile>
}
