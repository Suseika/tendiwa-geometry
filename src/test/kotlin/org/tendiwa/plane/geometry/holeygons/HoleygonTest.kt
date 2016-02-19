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

    @Test
    fun `can contain single polygon`() {
        Holeygon(
            Rectangle(0.0, 0.0, 10.0, 10.0),
            listOf()
        )
            .polygons
            .apply { assertEquals(1, size) }
    }

    @Test
    fun `can contain many polygons`() {
        Holeygon(
            Rectangle(0.0, 0.0, 10.0, 10.0),
            listOf(
                Rectangle(1.0, 1.0, 1.0, 1.0),
                Rectangle(3.0, 3.0, 1.0, 1.0)
                )
        )
            .polygons
            .apply { assertEquals(3, size) }
    }

}
