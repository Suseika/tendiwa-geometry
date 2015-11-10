package org.tendiwa.geometry.grid.constructors

import org.tendiwa.geometry.grid.dimensions.GridDimension
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.tiles.Tile
import org.tendiwa.math.integers.even

/**
 * Creates a [GridRectangle] centered at a particular tile. Because it is
 * centered, its size must have odd width and height.
 * @param tile Center of a rectangle.
 * @param size Size of a rectangle. Must have odd width and height.
 * @throws IllegalArgumentException If width or height is even.
 */
fun centeredGridRectangle(tile: Tile, size: GridDimension): GridRectangle {
    if (size.width.even || size.height.even) {
        throw IllegalArgumentException(
            "Size must have odd width and height; size is $size"
        )
    }
    return GridRectangle(
        tile.x - (size.width - 1) / 2,
        tile.y - (size.height - 1) / 2,
        size.width,
        size.height
    )
}


