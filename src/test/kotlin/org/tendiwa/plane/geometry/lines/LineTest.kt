package org.tendiwa.plane.geometry.lines

import org.junit.Test
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.lineThrough

class LineTest {
    @Test fun lineTest() {
        assert(
            Point(3.0, 5.0)
                .lineThrough(Point(5.0, 7.0))
                .contains(Point(7.0, 9.0))
        )
    }
}
