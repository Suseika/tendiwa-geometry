package org.tendiwa.geometry.grid.masks.borders

import org.tendiwa.geometry.grid.masks.BoundedGridMask
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.rectangles.maxX
import org.tendiwa.geometry.grid.rectangles.maxY
import org.tendiwa.geometry.grid.rectangles.xAxisRange

val GridRectangle.border: BoundedGridMask
    get() = object : BoundedGridMask {
        override val hull = this@border

        override fun contains(x: Int, y: Int): Boolean =
            x == hull.x || y == hull.y || x == hull.maxX || y == hull.maxY

        override fun forEachTile(operation: (Int, Int) -> Unit) {
            for (x in xAxisRange) {
                operation(x, hull.y)
            }
            for (y in hull.y + 1..hull.maxY) {
                operation(hull.x, y)
            }
            for (x in hull.maxX - 1 downTo hull.x) {
                operation(x, hull.maxX)
            }
            for (y in hull.maxY - 1 downTo hull.y + 1) {
                operation(hull.x, y)
            }
        }
    }

