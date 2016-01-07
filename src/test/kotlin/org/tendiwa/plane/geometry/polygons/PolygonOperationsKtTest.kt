package org.tendiwa.plane.geometry.polygons

import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.tendiwa.math.constants.EPSILON
import org.tendiwa.plane.directions.OrdinalDirection.NE
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.rectangles.Rectangle
import org.tendiwa.plane.geometry.trails.Polygon
import org.tendiwa.plane.geometry.vectors.*
import org.tendiwa.tools.expectIllegalArgument
import java.lang.Math.PI
import kotlin.test.assertFalse

class PolygonOperationsKtTest {
    @JvmField @Rule val expectRule = ExpectedException.none()

    @Test
    fun containsPoint() {
        assert(
            Polygon(Point(0.0, 0.0), {
                moveY(1.0)
                moveX(1.0)
                moveY(2.0)
                move(4.0, -2.5)
            })
                .contains(Point(2.0, 1.0))
        )
    }

    @Test
    fun doesntContainPoint() {
        assertFalse(
            Polygon(Point(0.0, 0.0), {
                moveY(1.0)
                moveX(1.0)
                moveY(2.0)
                move(4.0, -2.5)
            })
                .contains(Point(0.5, 2.0))
        )
    }

    @Test
    fun findsIthSegment() {
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .apply { assertEquals(segments[0], segment(0)) }
    }

    @Test
    fun segmentFailsWithIndexLT0() {
        expectRule.expectIllegalArgument(
            "index must be a valid index of a polygon point"
        )
        Rectangle(0.0, 0.0, 10.0, 10.0).segment(-1)
    }

    @Test
    fun segmentFailsWithIndexGTSizeOfPoints() {
        expectRule.expectIllegalArgument(
            "index must be a valid index of a polygon point"
        )
        Rectangle(0.0, 0.0, 10.0, 10.0).segment(5)
    }

    @Test
    fun cornerContainsTheProvidedPoint() {
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .apply { assertEquals(points[1], corner(1).point) }
    }

    @Test
    fun cornerContainsSectorBetweenTwoSides() {
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .corner(1)
            .apply {
                assertEquals(
                    HorizontalVector(-10.0),
                    sector.cw.toPositiveZeroVector()
                )
            }
            .apply { assertEquals(VerticalVector(10.0), sector.ccw) }
    }

    @Test
    fun createsOutwardCorner() {
        val rectangle = Rectangle(0.0, 0.0, 10.0, 10.0)
        rectangle
            .corner(1, inward = false)
            .apply { assertEquals(rectangle.points[1], point) }
            .apply {
                assertEquals(PI / 2 * 3, sector.angle, EPSILON)
            }
            .sector
            .bisector
            .apply { assert(isInQuarter(NE)) }
    }

    @Test
    fun cornerOfCCWCycleFacesCorrectDirection() {
        Polygon(Point(0.0, 0.0), {
            moveX(-10.0)
            moveY(10.0)
            moveX(10.0)
        })
            .corner(0)
            .sector
            .angle
            .apply { assertEquals(PI / 2, this, EPSILON) }
    }

    @Test
    fun sumOfAllInwardCorners() {
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .corners(inward = true)
            .map { it.sector.angle }
            // https://en.wikipedia.org/wiki/Polygon#Angles
            .apply {
                assertEquals(
                    (size - 2) * PI,
                    sum(),
                    EPSILON
                )
            }
    }

    @Test
    fun sumOfAllOutwardCorners() {
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .corners(inward = false)
            .map { it.sector.angle }
            // https://en.wikipedia.org/wiki/Polygon#Angles
            .apply {
                assertEquals(
                    (size + 2) * PI,
                    sum(),
                    EPSILON
                )
            }
    }
}
