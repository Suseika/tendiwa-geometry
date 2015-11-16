package org.tendiwa.geometry.segments

import org.junit.Test
import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.points.move
import org.tendiwa.geometry.points.reallyCloseTo
import org.tendiwa.geometry.segments.Segment
import org.tendiwa.geometry.segments.move
import org.tendiwa.geometry.segments.parallel
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

