package org.tendiwa.plane.geometry.corners

import org.junit.Assert
import org.junit.Test
import org.tendiwa.math.angles.Angle
import org.tendiwa.math.angles.times
import org.tendiwa.math.constants.EPSILON
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.vectors.angle

class CornerTest {
    @Test
    fun createsCornerFrom3Points() {
        val corner = fun(right: Boolean) =
            Corner(
                Point(0.0, 0.0),
                Point(0.0, 10.0),
                Point(10.0, 10.0),
                right
            )
        corner(false)
            .sector
            .apply {
                Assert.assertEquals(
                    Angle.RIGHT.radians,
                    angle.radians,
                    EPSILON
                )
            }
        corner(true)
            .sector
            .apply {
                Assert.assertEquals(
                    (Angle.RIGHT * 3.0).radians,
                    angle.radians,
                    EPSILON
                )
            }
    }
}
