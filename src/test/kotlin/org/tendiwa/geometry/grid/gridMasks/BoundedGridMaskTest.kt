package org.tendiwa.geometry.grid.gridMasks

import org.junit.Test
import org.tendiwa.geometry.grid.rectangles.GridRectangle

class BoundedGridMaskTest {
    @Test fun inverts() {
        val original = GridRectangle(0, 0, 3, 3)
        val inverse = original.inverse
        assert(!original.tiles.any { inverse.contains(it) })
    }
}
