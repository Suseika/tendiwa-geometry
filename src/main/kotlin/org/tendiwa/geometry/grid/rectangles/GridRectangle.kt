package org.tendiwa.geometry.grid.rectangles

import org.tendiwa.geometry.grid.masks.BoundedGridMask
import org.tendiwa.geometry.grid.tiles.Tile

/**
 * An axis-parallel rectangle over points in ℤ×ℤ.
 * @property x X coordinate of the top left corner.
 * @property y Y coordinate of the top left corner.
 * @property width Width.
 * @property height Height.
 */
data class GridRectangle(
    val x: Int,
    val y: Int,
    val width: Int,
    val height: Int
) : BoundedGridMask {
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
