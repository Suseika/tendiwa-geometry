package org.tendiwa.plane.geometry.vectors

import org.junit.Assert
import org.junit.Test
import org.tendiwa.math.angles.AngularMeasure
import org.tendiwa.math.constants.EPSILON
import org.tendiwa.plane.directions.OrdinalDirection.SW
import kotlin.test.assertEquals

class VectorSectorPropertiesKtTest {
    @Test
    fun angle() {
        VectorSector(
            cw = HorizontalVector(1.0),
            ccw = VerticalVector(1.0)
        )
            .angularMeasure
            .apply {
                Assert.assertEquals(
                    AngularMeasure.RIGHT.radians,
                    this.radians,
                    EPSILON
                )
            }
    }

    @Test
    fun `angle between sectors separated by x axis`() {
        VectorSector(
            cw = Vector(1.0, -1.0),
            ccw = Vector(1.0, 1.0)
        )
            .angularMeasure
            .apply {
                Assert.assertEquals(
                    AngularMeasure.RIGHT.radians,
                    this.radians,
                    EPSILON
                )
            }
    }

    @Test
    fun `bisector of reflex sector is directed away from vector sum`() {
        VectorSector(
            cw = VerticalVector(1.0),
            ccw = HorizontalVector(1.0)
        )
            .apply { assertEquals(SW.radians, bisector.direction.radians) }
    }
}
