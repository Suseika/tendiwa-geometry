package org.tendiwa.geometry.segments

import org.junit.Assert
import org.junit.Test
import org.tendiwa.geometry.points.spanHorizontalSegment
import org.tendiwa.geometry.points.spanSegment
import org.tendiwa.geometry.points.spanVerticalSegment
import org.tendiwa.geometry.points.*
import org.tendiwa.geometry.rectangles.contains
import org.tendiwa.math.constants.EPSILON
import org.tendiwa.math.doubles.sqrt
import org.tendiwa.plane.directions.CardinalDirection.N
import org.tendiwa.plane.directions.OrdinalDirection.SE
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class SegmentTest {
    @Test fun parallel() {
        val start = Point(3.0, 4.0)
        val original = Segment(start, start.move(4.0, 4.0))
        val parallel = original.parallel(2.0.sqrt, true)
        var expectedParallel = original.move(1.0, -1.0)
        assert(expectedParallel.start reallyCloseTo parallel.start)
        assert(expectedParallel.end reallyCloseTo parallel.end)
    }

    @Test fun isParallel() {
        horizontalLinesAreParallel()
        verticalLinesAreParallel()
        collinearDiagonalLinesAreParallel()
    }

    @Test fun collinearDiagonalLinesAreParallel() {
        AnyPoint().spanSegment(SE, 50.0).apply {
            assert(
                this.isParallel(
                    AnyPoint().moveHorizontally(10.0).spanSegment(SE, 50.0)
                )
            )
            assert(
                this.isParallel(
                    AnyPoint().moveHorizontally(10.0).spanSegment(SE, -50.0)
                )
            )
        }
        assert(
            AnyPoint().spanSegment(SE, 50.0).isParallel(
                AnyPoint().moveHorizontally(10.0).spanSegment(SE, -50.0)
            )
        )
    }

    @Test fun verticalLinesAreParallel() {
        assert(
            AnyPoint().spanVerticalSegment(50.0).isParallel(
                AnyPoint().moveHorizontally(10.0).spanVerticalSegment(50.0)
            )
        )
    }

    @Test fun horizontalLinesAreParallel() {
        assert(
            AnyPoint().spanHorizontalSegment(50.0).isParallel(
                AnyPoint().moveVertically(10.0).spanHorizontalSegment(50.0)
            )
        )
    }

    @Test fun segmentsCanBeNonParallel() {
        AnyPoint().apply {
            assertFalse(
                this.spanSegment(SE, 10.0)
                    .isParallel(this.spanSegment(N, 10.0))
            )
        }
    }

    @Test fun middleIsEquidistantToBothEnds() {
        Segment.ANY
            .apply {
                Assert.assertEquals(
                    start.distanceTo(middle()),
                    end.distanceTo(middle()),
                    EPSILON
                )
            }
    }

    @Test
    fun sliderCanBeOnSegmentEndpoints() {
        Segment.ANY
            .apply { assertEquals(start, slider(0.0)) }
            .apply { assertEquals(end, slider(1.0)) }
    }

    @Test
    fun sliderCanBeInsideSegment() {
        Segment.ANY
            .apply { assert(hull.contains(slider(0.4))) }
    }

    @Test
    fun sliderCanBeOutsideSegment() {
        Segment.ANY
            .apply { assert(!hull.contains(slider(3.4))) }
        Segment.ANY
            .apply { assert(!hull.contains(slider(-0.5))) }
    }
}

