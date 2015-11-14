package org.tendiwa.geometry.grid.segments.ortho

import org.junit.Test
import org.tendiwa.geometry.grid.directions.CardinalDirection.E
import org.tendiwa.geometry.grid.directions.CardinalDirection.W
import org.tendiwa.geometry.grid.directions.OrdinalDirection.NE
import org.tendiwa.geometry.grid.masks.contains
import org.tendiwa.geometry.grid.tiles.Tile
import org.tendiwa.geometry.grid.tiles.move
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HorizontalGridSegmentTest {
    @Test fun containsCorrectTiles() {
        val start = Tile(20, 40)
        val length = 5
        val segment = HorizontalGridSegment(start, length)
        assertTrue(segment.contains(start))
        assertTrue(segment.contains(start.move(E, length - 1)))
        assertFalse(segment.contains(start.move(W)))
        assertFalse(segment.contains(start.move(E, length)))
        assertFalse(segment.contains(start.move(NE)))
    }

    @Test fun endX() {
        assertEquals(14, HorizontalGridSegment(Tile(10, 20), 5).endX)
    }

    @Test fun endY() {
        assertEquals(20, HorizontalGridSegment(Tile(10, 20), 5).endY)
    }
}
