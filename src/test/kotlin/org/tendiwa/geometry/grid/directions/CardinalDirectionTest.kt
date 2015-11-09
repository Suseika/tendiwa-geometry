package org.tendiwa.geometry.grid.directions

import org.junit.Test
import kotlin.test.assertEquals

class CardinalDirectionTest {
    @Test fun cw4() {
        assertEquals(
            CardinalDirection.N,
            CardinalDirection.N.cw4.cw4.cw4.cw4
        )
    }

    @Test fun cww4() {
        assertEquals(
            CardinalDirection.N,
            CardinalDirection.N.ccw4.ccw4.ccw4.ccw4
        )
    }

    @Test fun cw8() {
        assertEquals(
            CardinalDirection.N,
            CardinalDirection.N.cw8.cw8.cw8.cw8.cw8.cw8.cw8.cw8
        )
    }

    @Test fun ccw8() {
        assertEquals(
            CardinalDirection.N,
            CardinalDirection.N.ccw8.ccw8.ccw8.ccw8.ccw8.ccw8.ccw8.ccw8
        )
    }
}
