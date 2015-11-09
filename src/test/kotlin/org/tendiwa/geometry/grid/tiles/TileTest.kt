package org.tendiwa.geometry.grid.tiles

import org.junit.Assert
import org.junit.Test

/**
 * Unit tests for [Tile].
 */
class TileTest {
    /**
     * Test for [Tile.distanceTo].
     */
    @Test fun distanceTo() {
        Assert.assertEquals(
            10.0,
            Tile(0, 0) distanceTo Tile(0, 10),
            0.01
        )
    }

    /**
     * Test for [Tile.move].
     */
    @Test fun move() {
        Assert.assertEquals(
            Tile(11,12),
            Tile(0, 0).move(11,12)
        )
    }
}
