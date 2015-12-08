package org.tendiwa.geometry.polygons

import org.junit.Test
import org.tendiwa.geometry.constructors.segmentTo
import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.rectangles.Rectangle
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFalse

class PolygonTest {
    @Test fun segments() {
        val a = Point(1.0, 2.0)
        val b = Point(10.0, 20.0)
        val c = Point(13.0, 59.0)
        val polygon = Polygon(a, b, c)
        assert(polygon.segments.contains(a segmentTo  b))
        assert(polygon.segments.contains(b segmentTo c))
        assert(polygon.segments.contains(c segmentTo a))
        assertFalse(polygon.segments.contains(b segmentTo a))
        assertFalse(polygon.segments.contains(c segmentTo b))
        assertFalse(polygon.segments.contains(a segmentTo c))
        assert(polygon.segments.size == 3)
    }

    @Test fun failsWhenTooFewPointsAreProvided() {
        assertFails { Polygon(listOf()) }
        assertFails { Polygon(listOf(Point(0.0, 0.0))) }
        assertFails { Polygon(listOf(Point(0.0, 0.0), Point(0.0, 2.3))) }
    }

    @Test fun perimeter() {
        assertEquals(
            40.0,
            Rectangle(0.0, 0.0, 10.0, 10.0).perimeter
        )
    }
}
