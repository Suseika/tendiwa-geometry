package org.tendiwa.geometry.grid.gridMasks

infix fun GridMask.union(another: GridMask): GridMask =
    GridMask {
        x, y ->
        this@union.contains(x, y) && another.contains(x, y)
    }

infix fun GridMask.difference(another: GridMask): GridMask =
    GridMask {
        x, y ->
        this@difference.contains(x, y) && !another.contains(x, y)
    }




