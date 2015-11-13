package org.tendiwa.geometry.grid.rectangles

import org.junit.Test
import org.tendiwa.geometry.grid.masks.contains
import org.tendiwa.geometry.grid.tiles.Tile
import org.tendiwa.geometry.grid.tiles.move
import kotlin.test.assertFalse

class GridSquareTest {
    @Test fun contains() {
        val corner = Tile(5, 5)
        val square = GridSquare(corner.x, corner.y, 4)
        assert(square.contains(corner))
        assert(square.contains(corner.move(2, 2)))
        assertFalse(square.contains(corner.move(-1, 0)))
        assertFalse(square.contains(corner.move(6, 0)))
        assertFalse(square.contains(corner.move(0, 6)))
    }
}
