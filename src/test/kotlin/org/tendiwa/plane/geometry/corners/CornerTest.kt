package org.tendiwa.plane.geometry.corners

import org.junit.Assert
import org.junit.Test
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
            .apply { Assert.assertEquals(Math.PI / 2, angle, EPSILON) }
        corner(true)
            .sector
            .apply { Assert.assertEquals(Math.PI / 2 * 3, angle, EPSILON) }
    }
}
