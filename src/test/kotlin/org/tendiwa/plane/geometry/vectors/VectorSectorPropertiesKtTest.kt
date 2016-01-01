package org.tendiwa.plane.geometry.vectors

import org.junit.Assert
import org.junit.Test
import org.tendiwa.math.constants.EPSILON

class VectorSectorPropertiesKtTest {
    @Test
    fun angle() {
        VectorSector(
            cw = Vector(0.0, 1.0),
            ccw = Vector(1.0, 0.0)
        )
            .angle
            .apply { Assert.assertEquals(Math.PI / 2, this, EPSILON) }
    }

    @Test
    fun angleBetweenVectorsSeparatedByXAxis() {
        VectorSector(
            cw = Vector(1.0, 1.0),
            ccw = Vector(1.0, -1.0)
        )
            .angle
            .apply { Assert.assertEquals(Math.PI / 2, this, EPSILON) }
    }
}
