package org.tendiwa.plane.geometry.vectors

import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.tendiwa.math.angles.Angle
import org.tendiwa.math.constants.EPSILON
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class VectorTest {
    @JvmField @Rule val expectRule = ExpectedException.none()

    @Test fun detectsCollinearVectors() {
        val dx = 3.0
        val dy = 4.0
        assert(Vector(dx, dy) isCollinear Vector(-2 * dx, -2 * dy))
    }

    @Test fun zeroVectorIsNotCollinearWithAnything() {
        val a = Vector(1.0, 1.0)
        assertFalse(ZERO_VECTOR isCollinear a)
        assertFalse(a isCollinear ZERO_VECTOR)
    }

    @Test fun angleBetween() {
        Assert.assertEquals(
            Angle.RIGHT.radians,
            HorizontalVector(1.0)
                .angleBetween(VerticalVector(1.0), true)
                .radians,
            EPSILON
        )
    }

    @Test
    fun failsToComputeAngleBetweenEqualVectors() {
        expectRule.expectMessage("Can't compute angle between equal vectors")
        expectRule.expect(IllegalArgumentException::class.java)

        HorizontalVector(1.0).apply {
            Assert.assertEquals(
                0.0,
                this.angleBetween(this, true).radians,
                EPSILON
            )
        }
    }

    @Test
    fun direction() {
        assertEquals(
            Math.PI / 4,
            Vector(2.0, 2.0).direction
        )
        assertEquals(
            Math.PI * 7 / 4,
            Vector(2.0, -2.0).direction
        )
    }
}

