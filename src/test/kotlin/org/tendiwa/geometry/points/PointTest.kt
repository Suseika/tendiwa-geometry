package org.tendiwa.geometry.points

import org.junit.Test
import org.tendiwa.plane.directions.OrdinalDirection.SE
import org.tendiwa.plane.directions.OrdinalDirection.SW
import kotlin.test.assertEquals

class PointTest {
    @Test
    fun lessSquaredDistanceMeansLessDistance() {
        val a = AnyPoint()
        val b = a.move(SW, 5.0)
        val c = a.move(SW, 4.0)
        assertSquaredDistanceComparesSameAsDistance(a, b, c)
    }

    @Test
    fun moreSquaredDistanceMeansMoreDistance() {
        val a = AnyPoint()
        val b = a.move(SE, 6.0)
        val c = a.move(SE, 10.0)
        assertSquaredDistanceComparesSameAsDistance(a, b, c)
    }

    @Test
    fun sameSquaredDistanceMeansSameDistance() {
        val a = AnyPoint()
        val b = a.move(SE, 5.1)
        val c = a.move(SW, 5.1)
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
