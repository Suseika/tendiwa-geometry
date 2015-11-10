package org.tendiwa.geometry.grid.masks

import org.tendiwa.geometry.grid.constructors.rectangularHull
import org.tendiwa.geometry.grid.tiles.Tile

infix fun GridMask.union(another: GridMask): GridMask =
    object : GridMask {
        override fun contains(x: Int, y: Int) =
            this@union.contains(x, y) && another.contains(x, y)
    }

infix fun GridMask.difference(another: GridMask): GridMask =
    object : GridMask {
        override fun contains(x: Int, y: Int) =
            this@difference.contains(x, y) && !another.contains(x, y)
    }

infix fun FiniteGridMask.intersection(
    another: FiniteGridMask
): FiniteGridMask {
    val commonTiles = this.tiles.intersect(another.tiles)
    return when {
        commonTiles.isEmpty() ->
            EmptyGridMask()
        else ->
            ArrayGridMask(object : BoundedGridMask {
                override val hull = commonTiles.rectangularHull

                override fun contains(x: Int, y: Int): Boolean {
                    return commonTiles.contains(Tile(x, y))
                }
            })
    }
}
