package org.tendiwa.geometry.continuum.shapes

import org.tendiwa.geometry.continuum.rectangles.maxX
import org.tendiwa.geometry.continuum.rectangles.maxY
import org.tendiwa.geometry.grid.rectangles.GridRectangle

val Shape.gridHull: GridRectangle
    get() {
        val hull = this.hull
        return GridRectangle(
            Math.floor(hull.x).toInt(),
            Math.floor(hull.y).toInt(),
            Math.ceil(hull.maxX).toInt(),
            Math.ceil(hull.maxY).toInt()
        )
    }

