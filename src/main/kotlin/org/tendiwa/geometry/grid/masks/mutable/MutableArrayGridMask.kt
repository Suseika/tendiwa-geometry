package org.tendiwa.geometry.grid.masks.mutable

import org.tendiwa.collectioins.BooleanArray2D
import org.tendiwa.geometry.grid.masks.BoundedGridMask
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.segments.ortho.HorizontalGridSegment
import java.util.*

class MutableArrayGridMask(
    override val hull: GridRectangle
) : BoundedGridMask, MutableGridMask {

    private val grid: Array<BooleanArray> =
        BooleanArray2D(hull.height, hull.width)

    override fun contains(x: Int, y: Int): Boolean {
        // Boils down to
        // return hull.contains(x, y) && grid[y.relativeY][x.relativeX],
        // but this implementation is optimized compared to that.
        val relY = y.relativeY
        val relX = x.relativeX
        if (!(relX >= 0 && relY >= 0 && relY < grid.size)) {
            return false
        }
        val row = grid[relY]
        if (relX >= row.size) {
            return false
        }
        return row[relX]
    }

    override fun add(x: Int, y: Int) {
        grid[y.relativeY][x.relativeX] = true
    }

    override fun remove(x: Int, y: Int) {
        grid[y.relativeY][x.relativeX] = false
    }

    fun fillHorizontalSegment(segment: HorizontalGridSegment) {
        Arrays.fill(
            grid[segment.start.y.relativeY],
            segment.start.x.relativeX,
            segment.endX.relativeX + 1,
            true
        )
    }

    private val Int.relativeX: Int
        get() = this - hull.x

    private val Int.relativeY: Int
        get() = this - hull.y
}
