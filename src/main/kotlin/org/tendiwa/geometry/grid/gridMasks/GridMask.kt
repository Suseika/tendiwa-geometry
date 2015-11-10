package org.tendiwa.geometry.grid.gridMasks

interface GridMask {
    fun contains(x: Int, y: Int): Boolean
}
