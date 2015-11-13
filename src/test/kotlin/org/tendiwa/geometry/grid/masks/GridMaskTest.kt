package org.tendiwa.geometry.grid.masks

import org.junit.Test
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GridMaskTest {
    @Test fun union() {
        val union = GridRectangle(0, 0, 10, 10) union GridRectangle(5, 5, 2, 2)
        assertTrue(union.contains(5, 5))
        assertFalse(union.contains(9, 9))
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

