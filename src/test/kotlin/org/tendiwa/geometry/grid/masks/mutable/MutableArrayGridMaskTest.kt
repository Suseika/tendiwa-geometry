package org.tendiwa.geometry.grid.masks.mutable

import org.junit.Test
import org.tendiwa.geometry.grid.directions.CardinalDirection.E
import org.tendiwa.geometry.grid.directions.OrdinalDirection.NW
import org.tendiwa.geometry.grid.directions.OrdinalDirection.SE
import org.tendiwa.geometry.grid.masks.contains
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.rectangles.corner
import org.tendiwa.geometry.grid.rectangles.shrink
import org.tendiwa.geometry.grid.segments.ortho.HorizontalGridSegment
import org.tendiwa.geometry.grid.tiles.Tile
import org.tendiwa.geometry.grid.tiles.move
import kotlin.test.assertFails
import kotlin.test.assertFalse

class MutableArrayGridMaskTest {
    @Test fun contains() {
        val hull = GridRectangle(1, 2, 3, 4)
        val mask = MutableArrayGridMask(hull)
        hull.shrink(1).tiles.forEach {
            mask.add(it.x, it.y)
        }
        assert(mask.contains(hull.corner(NW).move(SE)))
        assertFalse(mask.contains(hull.corner(NW)))
        assertFalse(mask.contains(hull.corner(NW).move(NW)))
        assertFalse(mask.contains(hull.corner(SE).move(E)))
    }

    @Test fun fillHorizontalSegment() {
        val hull = GridRectangle(10, 20, 100, 50)
        val mask = MutableArrayGridMask(hull)
        val segment = HorizontalGridSegment(Tile(30, 30), 3)
        mask.fillHorizontalSegment(segment)
        hull.tiles.forEach {
            assert(mask.contains(it.x, it.y) == segment.contains(it.x, it.y))
        }
    }

    @Test fun removesTiles() {
        val mask = MutableArrayGridMask(GridRectangle(0, 0, 2, 1))
        mask.add(0, 0)
        mask.add(1, 0)
        mask.remove(1, 0)
        assert(mask.contains(0, 0))
        assertFalse(mask.contains(1, 0))
    }

    @Test fun failsWhenEditedOutOfBounds() {
        MutableArrayGridMask(GridRectangle(0, 0, 3, 3)).apply {
            assertFails { add(-1, -1) }
            assertFails { remove(50, 50) }
        }
    }
}

