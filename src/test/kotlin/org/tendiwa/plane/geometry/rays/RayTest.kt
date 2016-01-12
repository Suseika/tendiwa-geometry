package org.tendiwa.plane.geometry.rays

import org.junit.Test
import org.tendiwa.plane.directions.OrdinalDirection.NE
import org.tendiwa.plane.directions.OrdinalDirection.SE
import org.tendiwa.plane.geometry.points.AnyPoint
import org.tendiwa.plane.geometry.points.move
import kotlin.test.assertEquals

class RayTest {
    @Test
    fun pointOnRay() {
        AnyPoint()
            .apply {
                assertEquals(
                    this.move(SE, 3.8),
                    Ray(this, NE).pointOnRay(3.8)
                )
            }
    }
}
