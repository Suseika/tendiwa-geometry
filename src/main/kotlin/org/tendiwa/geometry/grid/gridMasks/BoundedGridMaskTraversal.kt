package org.tendiwa.geometry.grid.gridMasks

import org.tendiwa.geometry.grid.rectangles.xAxisRange
import org.tendiwa.geometry.grid.rectangles.yAxisRange

fun BoundedGridMask.forEachTile(func: (Int, Int)->Unit) {
    for (x in hull.xAxisRange) {
        for (y in hull.yAxisRange) {
            func.invoke(x, y)
        }
    }
}
