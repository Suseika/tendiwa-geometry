package org.tendiwa.plane.geometry.vectors

import org.junit.Assert
import org.junit.Test
import org.tendiwa.math.angles.Angle
import org.tendiwa.math.constants.EPSILON

class VectorSectorPropertiesKtTest {
    @Test
    fun angle() {
        VectorSector(
            cw = VerticalVector(1.0),
            ccw = HorizontalVector(1.0)
        )
            .angle
            .apply {
                Assert.assertEquals(
                    Angle.RIGHT.radians,
                    this.radians,
                    EPSILON
                )
            }
    }

    @Test
    fun angleBetweenVectorsSeparatedByXAxis() {
        VectorSector(
            cw = Vector(1.0, 1.0),
            ccw = Vector(1.0, -1.0)
        )
            .angle
            .apply {
                Assert.assertEquals(
                    Angle.RIGHT.radians,
                    this.radians,
                    EPSILON
                )
            }
    }
}
