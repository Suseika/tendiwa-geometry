package org.tendiwa.plane.geometry.shapes

import org.junit.Test
import org.tendiwa.plane.directions.CardinalDirection.*
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.move
import org.tendiwa.plane.geometry.polylines.Polyline
import kotlin.test.assertEquals

class SegmentGroupTest {
    @Test
    fun `repeated points are used once`() {
        val center = Point(0.0, 0.0)
        val n = center.move(N, 1.0)
        val e = center.move(E, 1.0)
        val s = center.move(S, 1.0)
        val w = center.move(W, 1.0)
        SegmentGroup(
            Polyline(listOf(n, center, s)),
            Polyline(listOf(e, center, w))
        )
        .apply {
            assertEquals(5, points.size)
            assertEquals(4, segments.size)
        }
    }
}
