package org.tendiwa.geometry.grid.rectangles

import org.tendiwa.geometry.grid.tiles.Tile

fun GridRectangle(x: Int, y: Int, width: Int, height: Int): GridRectangle {
    return DefaultGridRectangle(x, y, width, height)
}

private data class DefaultGridRectangle(
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) : GridRectangle {
    override val hull = this

    override val tiles: Set<Tile>
        get() {
            val list: MutableList<Tile> = arrayListOf()
            forEachTile { x, y -> list.add(Tile(x, y)) }
            return list.toSet()
        }

    override fun contains(x: Int, y: Int): Boolean =
        (x in this.xAxisRange) && (y in this.yAxisRange)

    override fun forEachTile(operation: (Int, Int) -> Unit) {
        for (i in x..maxX) {
            for (j in y..maxY) {
                operation(i, j)
            }
        }
    }
}

