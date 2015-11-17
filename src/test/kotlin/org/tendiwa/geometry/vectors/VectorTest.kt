package org.tendiwa.geometry.vectors

import org.junit.Test
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
}

