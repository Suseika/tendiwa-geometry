package org.tendiwa.geometry.rays

import org.junit.Test
import org.tendiwa.geometry.points.AnyPoint
import org.tendiwa.geometry.points.move
import org.tendiwa.plane.directions.OrdinalDirection
import kotlin.test.assertEquals

class RayTest {
    @Test
    fun pointOnRay() {
        assertEquals(
            AnyPoint().move(OrdinalDirection.SE, 3.8),
            Ray(AnyPoint(), Math.PI / 4).pointOnRay(3.8)
        )
    }
}
