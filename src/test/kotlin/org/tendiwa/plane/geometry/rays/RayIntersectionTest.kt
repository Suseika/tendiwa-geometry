package org.tendiwa.plane.geometry.rays

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.segmentTo
import org.tendiwa.plane.geometry.segments.parallel

class RayIntersectionTest {
    @org.junit.Test
    fun segmentsDontIntersectWithEndPoints() {
        val a = Point(0.0, 0.0) segmentTo Point(4.0, 0.0)
        val b = Point(0.0, 0.0) segmentTo Point(4.0, 0.0)
        assertFalse(RayIntersection(a, b).segmentsIntersect())
    }

    @org.junit.Test
    fun segmentsDontIntersect() {
        val a = Point(0.0, 0.0) segmentTo Point(4.0, 0.0)
        val b = Point(2.0, -4.0) segmentTo Point(2.0, -2.0)
        assertFalse(RayIntersection(a, b).segmentsIntersect())
    }

    @org.junit.Test
    fun segmentsIntersect() {
        val a = Point(0.0, 0.0) segmentTo Point(4.0, 0.0)
        val b = Point(2.0, -2.0) segmentTo Point(2.0, 2.0)
        assertTrue(RayIntersection(a, b).segmentsIntersect())
    }

    @org.junit.Test
    fun linesIntersectWhenSegmentsDoNot() {
        val a = Point(0.0, 0.0).segmentTo(Point(4.0, 1.0))
        val b = Point(3.0, 5.0).segmentTo(Point(5.0, 2.0))
        val intersection = RayIntersection(a, b)
        assertTrue(intersection.intersects)
        assertTrue(!intersection.segmentsIntersect())
    }

    @org.junit.Test
    fun parallelDontIntersect() {
        val a = Point(0.0, 0.0) segmentTo Point(4.0, 0.0)
        val b = a.parallel(1.0, true)
        val intersection = RayIntersection(a, b)
        assertFalse(intersection.intersects)
    }
}
