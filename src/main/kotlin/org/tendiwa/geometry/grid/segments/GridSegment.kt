package org.tendiwa.geometry.grid.segments

import org.tendiwa.geometry.grid.masks.BoundedGridMask
import org.tendiwa.geometry.grid.tiles.Tile

/**
 * A segment formed by tiles using
 * [Bresenham line algorithm](https://en.wikipedia.org/wiki/Bresenham%27s_line_algorithm)
 */
interface GridSegment : BoundedGridMask {
    val start: Tile
    val end: Tile
    val tilesList: List<Tile>
}
