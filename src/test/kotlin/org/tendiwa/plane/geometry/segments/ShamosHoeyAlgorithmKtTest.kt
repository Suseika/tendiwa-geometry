package org.tendiwa.plane.geometry.segments

import org.tendiwa.plane.geometry.points.Point
import kotlin.test.assertFalse

class ShamosHoeyAlgorithmKtTest {
    @org.junit.Test fun segmentsIntersect() {
        assert(
            listOf(
                Segment(Point(0.0, 0.0), Point(0.0, 20.0)),
                Segment(Point(30.0, 0.0), Point(10.0, 20.0)),
                Segment(Point(-10.0, 10.0), Point(10.0, 10.0))
            ).areIntersected()
        )
    }

    @org.junit.Test fun segmentsDontIntersect() {
        assertFalse(
            listOf(
                Segment(Point(0.0, 0.0), Point(0.0, 20.0)),
                Segment(Point(30.0, 0.0), Point(10.0, 20.0)),
                Segment(Point(2.0, 50.0), Point(102.0, 60.0))
            ).areIntersected()
        )
    }
}

