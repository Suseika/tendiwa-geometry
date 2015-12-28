package org.tendiwa.plane.geometry.segments

import org.junit.Test
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.spanSegment
import kotlin.test.assertFalse

class SegmentOperationsKtTest {
    @Test
    fun segmentsIntersectIfTheyHaveACommonPoint() {
        val ab = Point(0.0, 0.0).spanSegment(5.0, 6.0)
        val cd = Point(5.0, 0.0).spanSegment(-5.0, 6.0)
        assert(ab.intersects(cd))
    }

    @Test
    fun segmentsDontIntersectIfTheyHaveACommonEndpoint() {
        val ab = Point(1.2, 3.4).spanSegment(5.6, 7.8)
        val ac = Point(1.2, 3.4).spanSegment(-5.6, -7.8)
        assertFalse(ab intersects ac)
    }

    @Test
    fun segmentsDontIntersectIfTheyDontHaveCommonPoints() {
        val ab = Point(0.0, 0.0).spanSegment(5.0, 6.0)
        val cd = Point(10.0, 10.0).spanSegment(7.0, 8.0)
        assertFalse(ab intersects cd)
    }

    @Test
    fun segmentsDontIntersectIfTheyOverlap() {
        val ab = Point(0.0, 0.0).spanSegment(10.0, 6.0)
        val cd = ab.move(5.0, 3.0)
        assertFalse(ab intersects cd)
    }

    @Test
    fun segmentsDontIntersectIfTheyOverlapAndHaveCommonStart() {
        val ab = Point(0.0, 0.0).spanSegment(10.0, 6.0)
        val ac = Point(0.0, 0.0).spanSegment(5.0, 3.0)
        assertFalse(ab intersects ac)
    }

    @Test
    fun segmentsDontIntersectIfTheyOverlapAndHaveCommonEnd() {
        val ab = Point(0.0, 0.0).spanSegment(10.0, 6.0)
        val ac = Point(5.0, 3.0).spanSegment(5.0, 3.0)
        assertFalse(ab intersects ac)
    }

    @Test
    fun segmentsDontIntersectIfOneIsWithinAnother() {
        val ab = Point(0.0, 0.0).spanSegment(5.0, 3.0)
        val ac = Point(-5.0, -3.0).spanSegment(15.0, 9.0)
        assertFalse(ab intersects ac)
    }
}
