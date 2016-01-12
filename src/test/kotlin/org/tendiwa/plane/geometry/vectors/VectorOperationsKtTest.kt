package org.tendiwa.plane.geometry.vectors

import org.junit.Test
import org.tendiwa.plane.directions.CardinalDirection.S
import org.tendiwa.plane.directions.OrdinalDirection.*
import kotlin.test.assertEquals

class VectorOperationsKtTest {
    @Test
    fun isInQuarter() {
        Vector(1.0, -1.0)
            .apply {
                assert(isInQuarter(NE))
                assert(listOf(SE, SW, NW).all { !isInQuarter(it) })
            }
        Vector(1.0, 1.0)
            .apply {
                assert(isInQuarter(SE))
                assert(listOf(NE, SW, NW).all { !isInQuarter(it) })
            }
        Vector(-1.0, 1.0)
            .apply {
                assert(isInQuarter(SW))
                assert(listOf(NE, SE, NW).all { !isInQuarter(it) })
            }
        Vector(-1.0, -1.0)
            .apply {
                assert(isInQuarter(NW))
                assert(listOf(NE, SE, SW).all { !isInQuarter(it) })
            }
    }

    @Test
    fun direction() {
        assertEquals(S.radians, VerticalVector(1.0).direction.radians)
    }
}
