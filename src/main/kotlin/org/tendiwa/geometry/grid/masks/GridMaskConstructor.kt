package org.tendiwa.geometry.grid.masks

/**
 * [GridMask] over cells that satisfy a predicate.
 */
fun GridMask(predicate: (Int, Int) -> Boolean): GridMask =
    object : GridMask {
        override fun contains(x: Int, y: Int): Boolean =
            predicate(x, y)
    }

