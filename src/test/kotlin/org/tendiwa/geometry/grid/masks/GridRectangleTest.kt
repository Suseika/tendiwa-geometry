package org.tendiwa.geometry.grid.masks

import org.junit.Test
import org.tendiwa.geometry.grid.directions.CardinalDirection.*
import org.tendiwa.geometry.grid.masks.borders.border
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.rectangles.sides.side
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

    @Test fun borderIteratesCorrectNumberOfTimes() {
        var iterations = 0
        val rectangle = GridRectangle(0, 0, 5, 5)
        rectangle.border.forEachTile { x, y -> iterations++ }
        assertEquals(
            rectangle.width + rectangle.height
                + (rectangle.width - 2) + (rectangle.height - 2),
            iterations
        )
    }

    @Test fun borderIteratesOverCorrectCells() {
        val rectangle = GridRectangle(0, 0, 3, 3)
        rectangle.border.tiles.apply {
            assert(containsAll(rectangle.side(N).tiles))
            assert(containsAll(rectangle.side(E).tiles))
            assert(containsAll(rectangle.side(S).tiles))
            assert(containsAll(rectangle.side(W).tiles))
        }
    }
}
