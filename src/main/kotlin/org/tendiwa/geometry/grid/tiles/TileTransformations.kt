package org.tendiwa.geometry.grid.tiles

import org.tendiwa.geometry.grid.directions.Direction

/**
 * Moves a cell relative to its location.
 * @param dx Shift by x axis.
 * @param dy Shift by y axis.
 * @return New cell relative to the original one.
 */
fun Tile.move(dx: Int, dy: Int): Tile =
    Tile(this.x + dx, this.y + dy)

fun Tile.move(direction: Direction, distance: Int = 1): Tile =
    Tile(
        this.x + direction.dx * distance,
        this.y + direction.dy * distance
    )


/**
 * Computes distance between two tiles.
 * @param tile Another grid.
 * @return Distance from this grid to another grid.
 */
infix fun Tile.distanceTo(tile: Tile): Double {
    val dx = tile.x - this.x
    val dy = tile.y - this.y
    return Math.sqrt(
        (dx * dx + dy * dy).toDouble()
    )
}
