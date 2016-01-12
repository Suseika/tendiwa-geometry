package org.tendiwa.plane.geometry.rays

import org.junit.Assert.assertEquals
import org.junit.Test
import org.tendiwa.math.constants.EPSILON
import org.tendiwa.plane.directions.CardinalDirection.*
import org.tendiwa.plane.directions.RadianDirection
import org.tendiwa.plane.geometry.points.AnyPoint
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.distanceTo
import org.tendiwa.plane.geometry.rectangles.Rectangle
import kotlin.test.assertNull

class RayOperationsKtTest {
    @Test
    fun sunReturnsSpecifiedNumberOfRays() {
        Ray(AnyPoint(), E)
            .sun(9)
            .apply { assertEquals(9, size) }
    }

    @Test
    fun raysOfSunHaveAnglesAtRegularIntervals() {
        Ray(AnyPoint(), RadianDirection(0.0)).sun(9)
            .map { it.direction.radians }
            .sum()
            .apply { assert(this > 0.0) }
            .let { it % Math.PI * 2 }
            .apply { assertEquals(0.0, this, EPSILON) }
    }

    @Test
    fun intersectionWithRectangle() {
        Ray(Point(10.0, 10.0), RadianDirection(Math.PI * 5 / 4))
            .closestIntersection(Rectangle(0.0, 0.0, 20.0, 20.0))!!
            .apply {
                assertEquals(0.0, distanceTo(Point(0.0, 0.0)), EPSILON)
            }
    }

    @Test
    fun firstIntersectionWithRectangleIsTheClosestOne() {
        Ray(Point(10.0, 10.0), RadianDirection(Math.PI * 5 / 4))
            .closestIntersection(Rectangle(0.0, 0.0, 20.0, 20.0))!!
            .apply {
                assertEquals(
                    0.0,
                    distanceTo(Point(0.0, 0.0)),
                    EPSILON
                )
            }
    }

    @Test
    fun canReturnNoIntersection() {
        assertNull(
            Ray(Point(20.0, 10.0), N)
                .closestIntersection(Rectangle(0.0, 0.0, 10.0, 10.0))
        )
    }

    @Test
    fun `ray inverts`() {
        Ray(Point(0.0, 0.0), E)
            .inverse()
            .apply {
                assertEquals(
                    W.radians,
                    direction.radians,
                    EPSILON
                )
            }
        Ray(Point(0.0, 0.0), N)
            .inverse()
            .apply {
                assertEquals(
                    S.radians,
                    direction.radians,
                    EPSILON
                )
            }
    }
}
