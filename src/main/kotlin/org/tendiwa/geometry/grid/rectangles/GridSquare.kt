package org.tendiwa.geometry.grid.rectangles

import org.tendiwa.geometry.grid.tiles.Tile

/**
 * @param x X coordinate of the top-left corner.
 * @param y Y coordinate of the top-left corner.
 */
data class GridSquare(
    override val x: Int,
    override val y: Int,
    override val width: Int
) : GridRectangle {
    override val height = width

    override val hull = this

    override val tiles: Set<Tile>
        get() {
            val list: MutableList<Tile> = arrayListOf()
            forEachTile { x, y -> list.add(Tile(x, y)) }
            return list.toSet()
        }

    override fun contains(x: Int, y: Int): Boolean =
        (x in this.x..this.maxX) && (y in this.y..this.maxY)

    override fun forEachTile(operation: (Int, Int) -> Unit) {
        for (i in x..maxX) {
            for (j in y..maxY) {
                operation(i, j)
            }
        }
    }
}
