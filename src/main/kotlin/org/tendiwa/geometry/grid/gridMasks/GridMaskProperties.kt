package org.tendiwa.geometry.grid.gridMasks

val GridMask.inverse: GridMask
    get() =
    object : GridMask {
        override fun contains(x: Int, y: Int): Boolean =
            !this@inverse.contains(x, y)
    }
