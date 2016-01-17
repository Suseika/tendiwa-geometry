package org.tendiwa.plane.geometry.trails

import org.junit.Test
import org.tendiwa.plane.directions.CardinalDirection.N
import org.tendiwa.plane.directions.OrdinalDirection.*
import org.tendiwa.plane.geometry.points.Point
import kotlin.test.assertEquals

class TrailTest {
    @Test fun remembersAllPoints() {
        assertEquals(
            6,
            Trail(Point(1.0, 2.0))
                .apply {
                    moveX(3.0)
                    moveY(4.0)
                    move(5.0, 6.0)
                    move(-7.0, N)
                    moveTo(Point(8.0, 9.0))
                }
                .points.size
        )
    }

    @Test fun move() {
        assertEquals(
            Point(30.0, 40.0),
            Trail(Point(20.0, 30.0)).apply { move(10.0, 10.0) }.points.last()
        )
    }

    @Test fun moveX() {
        assertEquals(
            Point(30.0, 40.5),
            Trail(Point(20.0, 40.5)).apply { moveX(10.0) }.points.last()
        )
    }

    @Test fun moveY() {
        assertEquals(
            Point(10.0, 12.4),
            Trail(Point(10.0, 10.0)).apply { moveY(2.4) }.points.last()
        )
    }

    @Test fun moveInDirection() {
        assertEquals(
            Point(13.0, 8.0),
            Trail(Point(10.0, 11.0)).apply { move(3.0, SE) }.points.last()
        )
    }

    @Test fun moveTo() {
        val target = Point(15.0, 16.0)
        assertEquals(
            target,
            Trail(Point(-100.0, -200.0)).apply { moveTo(target) }.points.last()
        )
    }
}
