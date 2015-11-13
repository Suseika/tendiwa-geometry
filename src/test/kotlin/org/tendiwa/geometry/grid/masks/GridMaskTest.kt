package org.tendiwa.geometry.grid.masks

import org.junit.Test
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.segments.GridSegment
import org.tendiwa.geometry.grid.tiles.Tile
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GridMaskTest {
    @Test fun intersection() {
        val intersection = GridRectangle(0, 0, 10, 10) intersection
            GridRectangle(5, 5, 2, 2)
        assertTrue(intersection.contains(5, 5))
        assertFalse(intersection.contains(9, 9))
        assertFalse(intersection.contains(-100, -100))
    }

    @Test fun union() {
        val union = GridSegment(Tile(0, 0), Tile(0, 5)) union
            GridRectangle(5, 5, 2, 2)
        assertTrue(union.contains(0, 0))
        assertTrue(union.contains(5, 5))
        assertFalse(union.contains(-100, -100))
    }

    @Test fun createdFromPredicate() {
        assertTrue(GridMask { x, y -> (x + y) % 2 == 0 }.contains(4, 6))
    }

    @Test fun move() {
        assertTrue {
            GridMask { x, y -> x == 1 && y == 2 }
                .move(4, 3)
                .contains(1 + 4, 2 + 3)
        }
    }
}

