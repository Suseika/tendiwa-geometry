package org.tendiwa.geometry.grid.masks

interface GridMask {
    fun contains(x: Int, y: Int): Boolean
}
