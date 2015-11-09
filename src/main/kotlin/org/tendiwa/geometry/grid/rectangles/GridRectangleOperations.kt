package org.tendiwa.geometry.grid.rectangles

fun GridRectangle.contains(x: Int, y: Int) =
    (x in this.x..this.maxX) && (y in this.x..this.maxY)

