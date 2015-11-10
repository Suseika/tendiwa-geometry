package org.tendiwa.geometry.grid.masks

import org.junit.Test
import org.tendiwa.geometry.grid.directions.OrdinalDirection.NW
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.rectangles.corner
import org.tendiwa.geometry.grid.tiles.move
import kotlin.test.assertFalse

class ArrayGridMaskTest {
    @Test fun doesNotContainTilesOutsideHull() {
        val hull = GridRectangle(1, 2, 3, 4)
        assertFalse(
            ArrayGridMask(hull)
                .contains(hull.corner(NW).move(-1, 0))
        )
    }
}
