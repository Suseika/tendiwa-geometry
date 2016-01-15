package org.tendiwa.plane.geometry.corners

import org.junit.Assert
import org.junit.Test
import org.tendiwa.math.angles.AngularMeasure
import org.tendiwa.math.angles.times
import org.tendiwa.math.constants.EPSILON
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.vectors.angularMeasure

class CornerTest {
    @Test
    fun `creates corner from 3 points`() {
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
                    (AngularMeasure.RIGHT * 3).radians,
                    angularMeasure.radians,
                    EPSILON
                )
            }
        corner(true)
            .sector
            .apply {
                Assert.assertEquals(
                    AngularMeasure.RIGHT.radians,
                    angularMeasure.radians,
                    EPSILON
                )
            }
    }
}
