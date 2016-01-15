package org.tendiwa.plane.geometry.angles

import org.junit.Test
import org.tendiwa.math.angles.AngularMeasure
import org.tendiwa.plane.directions.RadianDirection
import org.tendiwa.plane.geometry.points.Point
import java.lang.Math.PI
import kotlin.test.assertEquals

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
}
