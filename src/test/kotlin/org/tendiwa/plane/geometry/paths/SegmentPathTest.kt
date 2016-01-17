package org.tendiwa.plane.geometry.paths

import org.junit.Test
import org.tendiwa.plane.geometry.points.Point
import kotlin.test.assertEquals

class SegmentPathTest {
    @Test
    fun `constructs dipper from trail`() {
        SegmentPath(
            Point(1.2, 3.4),
            {
                moveX(10.0)
                moveX(1.0)
                moveY(1.0)
                moveX(-1.0)
                moveTo(points[2])
            }
        )
        .apply {
            println(points)
            assertEquals(6, points.size)
            assertEquals(5, points.toSet().size)
        }
    }
}
