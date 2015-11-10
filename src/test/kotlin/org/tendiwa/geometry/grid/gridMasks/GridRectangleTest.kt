package org.tendiwa.geometry.grid.gridMasks

import org.junit.Test
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.tiles.Tile
import kotlin.test.assertEquals

class GridRectangleTest {
    @Test fun createsItsTiles() {
        assertEquals(
            setOf(
                Tile(0, 0), Tile(0, 1), Tile(0, 2),
                Tile(1, 0), Tile(1, 1), Tile(1, 2),
                Tile(2, 0), Tile(2, 1), Tile(2, 2)
            ),
            GridRectangle(0, 0, 3, 3).tiles
        )
    }
}
