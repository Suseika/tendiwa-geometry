package org.tendiwa.plane.geometry.rays

import org.junit.Assert
import org.junit.Test
import org.tendiwa.math.constants.EPSILON
import org.tendiwa.plane.geometry.points.AnyPoint
import kotlin.test.assertEquals

class RayOperationsKtTest {
    @Test
    fun sunReturnsSpecifiedNumberOfRays() {
        Ray(AnyPoint(), 0.0).sun(9)
            .apply { assertEquals(9, size) }
    }

    @Test
    fun raysOfSunHaveAnglesAtRegularIntervals() {
        Ray(AnyPoint(), 0.0).sun(9)
            .map { it.direction }
            .sum()
            .apply { assert(this > 0.0) }
            .let { it % Math.PI * 2 }
            .apply { Assert.assertEquals(0.0, this, EPSILON) }
    }
}
