package org.tendiwa.plane.geometry.angles

import org.junit.Assert
import org.junit.Test
import org.tendiwa.math.angles.AngularMeasure
import org.tendiwa.math.constants.EPSILON
import org.tendiwa.plane.directions.CardinalDirection.*
import org.tendiwa.plane.directions.OrdinalDirection
import org.tendiwa.plane.directions.OrdinalDirection.*
import org.tendiwa.plane.directions.RadianDirection
import org.tendiwa.plane.geometry.points.Point
import java.lang.Math.PI
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class AngleTest {
    @Test
    fun `angular measure`() {
        Angle(
            Point(0.0, 0.0),
            RadianDirection(0.0),
            RadianDirection(PI / 2)
        )
            .apply { assertEquals(AngularMeasure.RIGHT, measure) }
    }


    @Test
    fun `bisector`() {
        Angle(Point(0.0, 0.0), cw = E, ccw = N)
            .apply {
                assertEquals(
                    OrdinalDirection.NE.radians,
                    bisector.direction.radians
                )
            }
    }

    @Test
    fun `measure of angle that contains 0 direction`() {
        Angle(Point(0.0, 0.0), cw = SE, ccw = N)
            .apply {
                Assert.assertEquals(
                    AngularMeasure(PI / 4 * 3).radians,
                    measure.radians,
                    EPSILON
                )
            }
    }

    @Test
    fun `angle can contain directions`() {
        Angle(Point(0.0, 0.0), cw = N, ccw = W)
            .apply { assert(contains(NW)) }
    }

    @Test
    fun `direction can be not contained in angle`() {
        Angle(Point(0.0, 0.0), cw = N, ccw = W)
            .apply { assertFalse(contains(NE)) }
    }

    @Test
    fun `transzero angle can contain directions`() {
        Angle(Point(0.0, 0.0), cw = SE, ccw = N)
            .apply { assert(contains(E)) }
    }

    @Test
    fun `direction can be not contained in transzero angle`() {
        Angle(Point(0.0, 0.0), cw = S, ccw = N)
            .apply { assertFalse(contains(W)) }
    }

    @Test
    fun `angle contains directions equal to sides`() {
        Angle(Point(0.0, 0.0), cw = S, ccw = SW)
            .apply { assert(contains(cw) && contains(ccw)) }
    }
}
