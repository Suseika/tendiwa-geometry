package org.tendiwa.geometry.grid.gridMasks

import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.tiles.Tile

/**
 * [GridMask] bounded by a [GridRectangle].
 */
interface BoundedGridMask : FiniteGridMask {
    /**
     * Bounds within which lie all the tiles of this [GridMask].
     */
    val hull: GridRectangle

    override val tiles: Set<Tile>
        get() =
        hull.tiles
            .filter { this@BoundedGridMask.contains(it.x, it.y) }
            .toSet()

    override fun forEachTile(operation: (Int, Int) -> Unit) {
        hull.forEachTile {
            x, y ->
            if (this@BoundedGridMask.contains(x, y)) {
                operation.invoke (x, y)
            }
        }
    }
}
