package org.tendiwa.plane.geometry.rectangles

import org.junit.Test
import org.tendiwa.math.constants.EPSILON
import org.tendiwa.plane.directions.OrdinalDirection.*
import org.tendiwa.plane.geometry.dimensions.by
import org.tendiwa.plane.geometry.points.AnyPoint
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.distanceTo
import org.tendiwa.plane.geometry.ranges2d.overlaps
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class RectangleTest {
    @Test
    fun hull() {
        assertEquals(
            Rectangle(-1.0, -1.0, 0.4, 0.4),
            Rectangle(-1.0, -1.0, 0.4, 0.4).hull
        )
    }

    @Test
    fun points() {
        assertEquals(
            listOf(
                Point(1.0, 2.0), Point(4.0, 2.0),
                Point(4.0, 6.0), Point(1.0, 6.0)
            ),
            Rectangle(1.0, 2.0, 3.0, 4.0).points
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun failsIfConstructedWith0Dimension() {
        Rectangle(AnyPoint(), 0.0 by 10.0)
    }

    @Test
    fun rectangleContainsInnerPoints() {
        assert(
            Rectangle(0.0, 0.0, 10.0, 10.0).contains(Point(3.4, 5.6))
        )
    }

    @Test
    fun rectangleDoesntContainOuterPoints() {
        assertFalse(
            Rectangle(0.0, 0.0, 10.0, 10.0).contains(Point(13.4, 5.6))
        )
    }

    @Test
    fun rectangleContainsPointOnBorder() {
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .apply { assert(contains(corner(SW))) }
    }

    @Test
    fun overlaps() {
        assert(
            Rectangle(0.0, 0.0, 10.0, 10.0)
                .overlaps(Rectangle(5.0, 5.0, 10.0, 10.0))
        )
    }

    @Test
    fun canBeNotOverlapping() {
        assertFalse(
            Rectangle(0.0, 0.0, 10.0, 10.0)
                .overlaps(Rectangle(15.0, 15.0, 10.0, 10.0))
        )
    }

    @Test
    fun adjacentRangesDontOverlap() {
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .apply {
                assertFalse(
                    this.overlaps(this.moveByX(this.width))
                )
            }
    }

    @Test
    fun pointAtRatio() {
        assert(
            Rectangle(0.0, 0.0, 10.0, 10.0)
                .pointAtRatio(0.5, 1.5)
                .distanceTo(Point(5.0, 15.0)) < EPSILON
        )
    }
}
