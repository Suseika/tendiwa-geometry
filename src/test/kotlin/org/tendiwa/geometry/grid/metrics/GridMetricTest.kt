package org.tendiwa.geometry.grid.metrics

import org.junit.Test
import kotlin.test.assertEquals

class GridMetricTest {
    @Test fun signums() {
        assertEquals(
            listOf(
                Pair(0, -1), Pair(1, -1), Pair(1, 0), Pair (1, 1),
                Pair(0, 1), Pair(-1, 1), Pair(-1, 0), Pair(-1, -1)
            ),
            GridMetric.KING.signums.asList()
        )
    }
}
