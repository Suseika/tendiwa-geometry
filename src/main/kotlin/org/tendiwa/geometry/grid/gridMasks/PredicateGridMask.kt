package org.tendiwa.geometry.grid.gridMasks

class PredicateGridMask(
    val predicate: (Int, Int) -> Boolean
) : GridMask {
    override fun contains(x: Int, y: Int): Boolean =
        predicate.invoke(x, y)
}
