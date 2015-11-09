package org.tendiwa.geometry.grid.tiles

/**
 * A square cell of unit size. My be considered a point in a ℤ×ℤ space.
 * @property x X coordinate.
 * @property y Y coordinate.
 */
data class Tile(
    val x: Int,
    val y: Int
)
