package org.tendiwa.plane.geometry.polygons

import org.junit.Test
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.trails.Polygon
import kotlin.test.assertFalse

class PolygonOperationsKtTest {
    @Test
    fun containsPoint() {
        assert(
            Polygon(Point(0.0, 0.0), {
                moveY(1.0)
                moveX(1.0)
                moveY(2.0)
                move(4.0, -2.5)
            })
                .contains(Point(2.0, 1.0))
        )
    }

    @Test
    fun doesntContainPoint() {
        assertFalse(
            Polygon(Point(0.0, 0.0), {
                moveY(1.0)
                moveX(1.0)
                moveY(2.0)
                move(4.0, -2.5)
            })
                .contains(Point(0.5, 2.0))
        )
    }
}
