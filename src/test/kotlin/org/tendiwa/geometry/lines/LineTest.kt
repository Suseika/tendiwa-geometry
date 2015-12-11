package org.tendiwa.geometry.lines

import org.junit.Test
import org.tendiwa.geometry.points.lineThrough
import org.tendiwa.geometry.points.Point

class LineTest {
    @Test fun lineTest() {
        assert(
            Point(3.0, 5.0)
                .lineThrough(Point(5.0, 7.0))
                .contains(Point(7.0, 9.0))
        )
    }
}
