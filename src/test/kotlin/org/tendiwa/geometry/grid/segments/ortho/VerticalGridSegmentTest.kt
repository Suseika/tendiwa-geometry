package org.tendiwa.geometry.grid.segments.ortho

import org.junit.Test
import org.tendiwa.geometry.grid.directions.CardinalDirection.N
import org.tendiwa.geometry.grid.directions.CardinalDirection.S
import org.tendiwa.geometry.grid.directions.OrdinalDirection.SE
import org.tendiwa.geometry.grid.masks.contains
import org.tendiwa.geometry.grid.tiles.Tile
import org.tendiwa.geometry.grid.tiles.move
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class VerticalGridSegmentTest {
    @Test fun containsCorrectTiles() {
        val start = Tile(20, 10)
        val length = 7
        val segment = VerticalGridSegment(start, length)
        assertTrue(segment.contains(start))
        assertTrue(segment.contains(start.move(S, length - 1)))
        assertFalse(segment.contains(start.move(N)))
        assertFalse(segment.contains(start.move(S, length)))
        assertFalse(segment.contains(start.move(SE, length)))
    }

    @Test fun endX() {
        assertEquals(10, VerticalGridSegment(Tile(10, 20), 5).endX)
    }

    @Test fun endY() {
        assertEquals(24, VerticalGridSegment(Tile(10, 20), 5).endY)
    }
}
