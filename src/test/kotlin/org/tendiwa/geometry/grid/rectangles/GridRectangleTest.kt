package org.tendiwa.geometry.grid.rectangles

import org.junit.Test
import org.tendiwa.geometry.continuum.constructors.gridRectangleByTopLeftCorner
import org.tendiwa.geometry.grid.dimensions.by
import org.tendiwa.geometry.grid.tiles.Tile
import kotlin.test.assertFalse

class GridRectangleTest {
    @Test fun contains() {
        val corner = Tile(3, 6)
        val size = 7 by 9;
        val rectangle = gridRectangleByTopLeftCorner(corner, size)
        assert(
            rectangle.contains(corner.x, corner.y)
        )
        assert(
            rectangle.contains(
                corner.x + size.width - 1,
                corner.y + size.height - 1
            )
        )
        assert(
            rectangle.contains(
                corner.x + size.width / 2,
                corner.y + size.height / 2
            )
        )
        assertFalse(
            rectangle.contains(
                corner.x + size.width,
                corner.y + size.height - 1
            )
        )
    }
}
