package org.tendiwa.geometry.continuum.segments

import org.junit.Test
import org.tendiwa.geometry.continuum.points.Point
import org.tendiwa.geometry.continuum.points.move
import org.tendiwa.geometry.continuum.points.reallyCloseTo
import org.tendiwa.math.doubles.sqrt

class SegmentTest {
    @Test fun parallel() {
        val start = Point(3.0, 4.0)
        val original = Segment(start, start.move(4.0, 4.0))
        val parallel = original.parallel(2.0.sqrt, true)
        var expectedParallel = original.move(1.0, -1.0)
        assert(expectedParallel.start reallyCloseTo parallel.start)
        assert(expectedParallel.end reallyCloseTo parallel.end)
    }
}

