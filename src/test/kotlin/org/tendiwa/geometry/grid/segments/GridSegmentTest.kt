package org.tendiwa.geometry.grid.segments

import org.junit.Test
import org.tendiwa.geometry.grid.tiles.Tile
import org.tendiwa.math.integers.even
import kotlin.test.assertEquals

class GridSegmentTest {
    @Test fun tiles() {
        assertEquals(
            6,
            GridSegment(Tile(0, 0), Tile(5, 0)).tiles.count()
        )
    }

    @Test fun middleComputesMiddle() {
        val segment = GridSegment(Tile(-1, 3), Tile(5, 9))
        println(segment.tilesList)
        assertEquals(
            segment.tilesList.middle,
            segment.middle
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun middleFailsAndEvenDimensions() {
        GridSegment(Tile(0, 0), Tile(0, 3)).middle
    }

    val <T> List<T>.middle: T
        get() {
            if (size.even) {
                throw IllegalArgumentException(
                    "List should have an odd number of elements. It has $size"
                )
            }
            return this[(size - 1) / 2]
        }
}
