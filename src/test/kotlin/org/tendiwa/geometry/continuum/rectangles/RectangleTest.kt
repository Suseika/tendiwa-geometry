package org.tendiwa.geometry.continuum.rectangles

import org.junit.Test
import org.tendiwa.geometry.continuum.points.Point
import kotlin.test.assertEquals

class RectangleTest {
    @Test fun hull() {
        assertEquals(
            Rectangle(-1.0, -1.0, 0.4, 0.4),
            Rectangle(-1.0, -1.0, 0.4, 0.4).hull
        )
    }

    @Test fun points() {
        assertEquals(
            listOf(
                Point(1.0, 2.0), Point(4.0, 2.0),
                Point(4.0, 6.0), Point(1.0, 6.0)
            ),
            Rectangle(1.0, 2.0, 3.0, 4.0).points
        )
    }
}
