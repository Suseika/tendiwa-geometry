package org.tendiwa.geometry.grid.gridMasks

import org.junit.Assert
import org.junit.Test
import org.tendiwa.geometry.grid.rectangles.GridRectangle

class GridMaskTest {
    @Test fun union() {
        val a = GridRectangle(0, 0, 10, 10)
        val b = GridRectangle (5, 5, 2, 2)
        val union = a union b
        Assert.assertTrue(union.contains(5, 5))
        Assert.assertFalse(union.contains(9, 9))
    }

    @Test fun createdFromPredicate() {
        Assert.assertTrue(
            PredicateGridMask({ x, y -> (x + y) % 2 == 0 })
                .contains(4, 6)
        )
    }
}

