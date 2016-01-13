package org.tendiwa.plane.geometry.vectors

import org.junit.Test
import org.tendiwa.plane.directions.CardinalDirection.N
import org.tendiwa.plane.directions.OrdinalDirection.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull

class VectorOperationsKtTest {
    @Test
    fun isInQuarter() {
        Vector(1.0, -1.0)
            .apply { assertEquals(SE, quarter) }
        Vector(1.0, 1.0)
            .apply { assertEquals(NE, quarter) }
        Vector(-1.0, 1.0)
            .apply { assertEquals(NW, quarter) }
        Vector(-1.0, -1.0)
            .apply { assertEquals(SW, quarter) }
    }

    @Test
    fun `axis parallel vectors are not in any quarter`() {
        assertNull(Vector(1.0, 0.0).quarter)
        assertNull(Vector(0.0, 1.0).quarter)
        assertNull(Vector(0.0, -1.0).quarter)
        assertNull(Vector(-1.0, 0.0).quarter)
    }

    @Test
    fun direction() {
        assertEquals(N.radians, VerticalVector(1.0).direction.radians)
    }

    @Test
    fun makesReflexAngle() {
        assert(
            HorizontalVector(1.0).makesReflexAngle(cw = VerticalVector(1.0))
        )
        assertFalse(
            VerticalVector(1.0).makesReflexAngle(cw = HorizontalVector(1.0))
        )
    }
}
