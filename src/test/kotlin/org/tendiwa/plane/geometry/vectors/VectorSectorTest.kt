package org.tendiwa.plane.geometry.vectors

import org.junit.Test
import org.tendiwa.plane.directions.CardinalDirection
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class VectorSectorTest {
    @Test fun bisector() {
        val cw = HorizontalVector(10.0)
        val ccw = VerticalVector(10.0)
        assertEquals(
            VectorSector(cw, ccw).bisector,
            (ccw + cw).normalized * 10.0
        )
    }

    @Test fun sumVector() {
        val cw = HorizontalVector(10.0)
        val ccw = VerticalVector(10.0)
        assertEquals(
            VectorSector(cw, ccw).sumVector,
            (cw + ccw).normalized * 10.0
        )
    }

    @Test
    fun `contains vector between cw and ccw`() {
        VectorSector(
            cw = Vector(0.0, 8.0),
            ccw = Vector(0.0, -13.0)
        )
            .apply { assert(contains(HorizontalVector(1.0))) }
    }

    @Test
    fun `doesnt contain vector not between cw and ccw`() {
        VectorSector(
            cw = VerticalVector(8.0),
            ccw = VerticalVector(-13.0)
        )
            .apply { assertFalse(contains(HorizontalVector(-1.0))) }
    }

    @Test
    fun `half circle sector has correct bisector`() {
        VectorSector(
            cw = HorizontalVector(1.0),
            ccw = HorizontalVector(-1.0)
        )
            .bisector
            .apply {
                assertEquals(CardinalDirection.N.radians, direction.radians)
            }


    }
}
