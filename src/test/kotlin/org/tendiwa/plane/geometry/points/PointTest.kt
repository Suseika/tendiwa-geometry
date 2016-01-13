package org.tendiwa.plane.geometry.points

import org.junit.Assert
import org.junit.Test
import org.tendiwa.math.constants.EPSILON
import org.tendiwa.math.doubles.isCloseToZero
import org.tendiwa.plane.directions.OrdinalDirection.*
import org.tendiwa.plane.geometry.rectangles.area
import org.tendiwa.plane.geometry.segments.Segment
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class PointTest {
    @Test
    fun lessSquaredDistanceMeansLessDistance() {
        val a = AnyPoint()
        val b = a.moveKing(SW, 5.0)
        val c = a.moveKing(SW, 4.0)
        assertSquaredDistanceComparesSameAsDistance(a, b, c)
    }

    @Test
    fun moreSquaredDistanceMeansMoreDistance() {
        val a = AnyPoint()
        val b = a.moveKing(SE, 6.0)
        val c = a.moveKing(SE, 10.0)
        assertSquaredDistanceComparesSameAsDistance(a, b, c)
    }

    @Test
    fun sameSquaredDistanceMeansSameDistance() {
        val a = AnyPoint()
        val b = a.moveKing(SE, 5.1)
        val c = a.moveKing(SW, 5.1)
        assertSquaredDistanceComparesSameAsDistance(a, b, c)
    }

    private fun assertSquaredDistanceComparesSameAsDistance(
        a: Point,
        b: Point,
        c: Point
    ) {
        assertEquals(
            a.distanceTo(b).compareTo(a.distanceTo(c)),
            a.squaredDistanceTo(b).compareTo(a.squaredDistanceTo(c))
        )
    }

    @Test
    fun moveInOrdinalDirectionMovesByCorrectDistance() {
        val point = AnyPoint()
        Assert.assertEquals(
            1.0,
            point.move(SE, 1.0).distanceTo(point),
            EPSILON
        )
    }

    @Test
    fun spanRectangle() {
        AnyPoint()
            .apply {
                assertEquals(
                    50.0, this.spanRectangle(this.move(25.0, 2.0)).area
                )
            }
    }

    @Test fun pointOnLineIsReallyCloseToIt() {
        val start = Point(4.0, 5.0)
        assert(
            start
                .distanceToLine(
                    Segment(start, start.move(3.0, 65.0))
                )
                .isCloseToZero
        )
    }

    @Test fun pointNearLine() {
        val start = Point(4.0, 5.0)
        val segment = Point(0.0, 0.0) segmentTo Point(10.0, 0.0)
        assertEquals(5.0, start.distanceToLine(segment))
    }

    @Test fun isLeftOf() {
        AnyPoint().apply {
            assert(
                this.moveKing(SE, 30.0).isLeftOf(this.spanSegment(SW, 30.0))
            )
        }
    }

    @Test fun pointRightFromTheSegmentIsNotLeftFromTheSegment() {
        AnyPoint().apply {
            assertFalse(
                this.moveKing(SE, 30.0).isLeftOf(this.spanSegment(NE, 30.0))
            )
        }
    }

    @Test fun pointOnSegmentIsNotLeftOfThatSegment() {
        AnyPoint().apply {
            assertFalse(
                this.isLeftOf(this.spanHorizontalSegment(10.0))
            )
        }
    }
}
