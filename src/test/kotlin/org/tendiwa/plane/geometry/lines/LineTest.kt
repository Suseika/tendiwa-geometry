package org.tendiwa.plane.geometry.lines

import org.junit.Test
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.lineThrough
import kotlin.test.assertEquals

class LineTest {
    @Test fun lineTest() {
        assert(
            Point(3.0, 5.0)
                .lineThrough(Point(5.0, 7.0))
                .contains(Point(7.0, 9.0))
        )
    }

    @Test
    fun `horizontal line is horizontal`() {
        HorizontalLine(1.0)
            .intersectionWith(
                Line(a = 1.0, b = 0.0, c = 2.0)
            )!!
            .apply {
                assertEquals(Point(2.0, 1.0), this)
            }
    }
}
