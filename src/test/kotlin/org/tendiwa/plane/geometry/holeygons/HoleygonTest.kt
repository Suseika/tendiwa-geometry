package org.tendiwa.plane.geometry.holeygons

import org.junit.Test
import org.tendiwa.plane.geometry.rectangles.Rectangle
import kotlin.test.assertEquals

class HoleygonTest {
    @Test
    fun containsSegmentsOfAllPolygons() {
        Holeygon(
            Rectangle(0.0, 0.0, 10.0, 10.0),
            listOf(
                Rectangle(5.0, 5.0, 1.0, 1.0)
            )
        )
            .segments
            .apply { assertEquals(8, size) }
    }

    @Test
    fun containsPointsOfAllPolygons() {
        Holeygon(
            Rectangle(0.0, 0.0, 10.0, 10.0),
            listOf(
                Rectangle(5.0, 5.0, 1.0, 1.0)
            )
        )
            .points
            .apply { assertEquals(8, size) }
    }
}
