package org.tendiwa.geometry.points

import org.junit.Test
import org.tendiwa.plane.directions.OrdinalDirection.SE
import org.tendiwa.plane.directions.OrdinalDirection.SW
import kotlin.test.assertEquals

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
}
