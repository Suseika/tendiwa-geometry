package org.tendiwa.geometry.grid.gridMasks

import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.rectangles.xAxisRange
import org.tendiwa.geometry.grid.rectangles.yAxisRange
import org.tendiwa.geometry.grid.tiles.Tile
import org.tendiwa.math.sets.cartesianProduct

/**
 * [GridMask] of tiles within a [GridRectangle].
 * @param hull Hull within which all tiles of this grid mask reside.
 */
final class RectangleGridMask(
    override val hull: GridRectangle
) : BoundedGridMask {
    override val tiles: Set<Tile>
        get() =
        (hull.xAxisRange.toSet() cartesianProduct hull.yAxisRange.toSet())
            .map { Tile(it.first, it.second) }
            .toSet()


    override fun contains(x: Int, y: Int): Boolean =
        this.xInRange(x) && this.yInRange(y)

    /**
     * Checks if x coordinate is in range of rectangle's x coordinates.
     */
    private fun xInRange(x: Int): Boolean =
        hull.xAxisRange.contains(x)

    /**
     * Checks if y coordinate is in range of rectangle's y coordinates.
     */
    private fun yInRange(y: Int): Boolean =
        hull.yAxisRange.contains(y)
}
