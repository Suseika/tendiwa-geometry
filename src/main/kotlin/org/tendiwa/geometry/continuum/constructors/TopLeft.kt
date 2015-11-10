package org.tendiwa.geometry.continuum.constructors

import org.tendiwa.geometry.grid.dimensions.GridDimension
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.tiles.Tile

fun gridRectangleByTopLeftCorner(
    topLeftCorner: Tile,
    size: GridDimension
): GridRectangle =
    GridRectangle(
        topLeftCorner.x,
        topLeftCorner.y,
        size.width,
        size.height
    )

