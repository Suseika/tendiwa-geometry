package org.tendiwa.plane.geometry.polygons

import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.tendiwa.math.angles.AngularMeasure
import org.tendiwa.math.angles.plus
import org.tendiwa.math.angles.times
import org.tendiwa.math.constants.EPSILON
import org.tendiwa.plane.directions.CardinalDirection.N
import org.tendiwa.plane.directions.CardinalDirection.W
import org.tendiwa.plane.geometry.angles.measure
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.rectangles.Rectangle
import org.tendiwa.plane.geometry.trails.Polygon
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
    fun `corner angle contains vector between two sides`() {
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .corner(1)
            .apply {
                assertEquals(
                    W.radians,
                    ccw.radians,
                    EPSILON
                )
            }
            .apply { assertEquals(N.radians, cw.radians, EPSILON) }
    }

    @Test
    fun `outward corner`() {
        val rectangle = Rectangle(0.0, 0.0, 10.0, 10.0)
        rectangle
            .corner(1, inward = false)
            .apply {
                assertEquals(
                    W.radians,
                    cw.radians,
                    EPSILON
                )
                assertEquals(
                    N.radians,
                    ccw.radians,
                    EPSILON
                )
            }
    }

    @Test
    fun `point of angle is the corner point`() {
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .apply {
                assertEquals(
                    points[1],
                    corner(1).point
                )
            }
    }

    @Test
    fun cornerOfCCWCycleFacesCorrectDirection() {
        Polygon(Point(0.0, 0.0), {
            moveX(-10.0)
            moveY(10.0)
            moveX(10.0)
        })
            .corner(0)
            .measure
            .apply {
                assertEquals(
                    AngularMeasure.RIGHT.radians,
                    this.radians,
                    EPSILON
                )
            }
    }

    @Test
    fun `sum of all inward corners satisfies formula`() {
        // Formula from https://en.wikipedia.org/wiki/Polygon#Angles
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .corners(inward = true)
            .map { it.measure.radians }
            .apply {
                assertEquals(
                    PI * (size - 2),
                    sum(),
                    EPSILON
                )
            }
    }

    @Test
    fun sumOfAllOutwardCorners() {
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .corners(inward = false)
            .map { it.measure }
            // https://en.wikipedia.org/wiki/Polygon#Angles
            .apply {
                assertEquals(
                    (AngularMeasure.HALF_CIRCLE * (size + 2)).radians,
                    reduce { a, b -> a + b }.radians,
                    EPSILON
                )
            }
    }
}
