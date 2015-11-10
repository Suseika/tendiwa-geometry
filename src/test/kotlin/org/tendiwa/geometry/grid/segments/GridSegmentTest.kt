package org.tendiwa.geometry.grid.segments

import org.junit.Test
import org.tendiwa.geometry.grid.tiles.Tile
import kotlin.test.assertEquals

class GridSegmentTest {

    @Test
    fun tiles() {
        assertEquals(
            6,
            GridSegment(Tile(0, 0), Tile(5, 0)).tiles.count()
        )
    }
}
