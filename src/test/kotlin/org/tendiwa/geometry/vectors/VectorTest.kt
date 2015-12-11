package org.tendiwa.geometry.vectors

import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import org.tendiwa.math.constants.EPSILON
import kotlin.test.assertFalse

class VectorTest {
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

    @Ignore
    // TODO: Wrong direction, need to investigate
    @Test fun angleTo() {
        Assert.assertEquals(
            Math.PI / 2,
            Vector(1.0, 0.0).angleBetween(Vector(0.0, 1.0), true),
            EPSILON
        )
    }
}

