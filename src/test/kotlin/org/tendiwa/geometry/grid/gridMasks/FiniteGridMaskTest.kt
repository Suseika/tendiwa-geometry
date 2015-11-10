package org.tendiwa.geometry.grid.gridMasks

import org.junit.Test
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import kotlin.test.assertEquals

class FiniteGridMaskTest {
    @Test fun intersection() {
        assertEquals(
            GridRectangle(5, 5, 5, 5)
                .tiles,
            GridRectangle(0, 0, 10, 10)
                .intersection(GridRectangle(5, 5, 10, 10))
                .tiles
        )
    }
}
