package org.tendiwa.geometry.continuum.polygons

import org.junit.Test
import org.tendiwa.geometry.constructors.segmentTo
import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.polygons.Polygon
import org.tendiwa.geometry.polygons.segments
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
}
