package org.tendiwa.plane.geometry.polygons.cut

import org.junit.Test
import org.tendiwa.plane.geometry.rectangles.Rectangle
import kotlin.test.assertEquals

class CutPolygonTransformationsKtTest {
    @Test
    fun transformsCutPolygonToPolygon() {
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .cut(0.2, 0.5, 0.6)
            .toPolygon()
            .apply { assertEquals(6, points.size) }
    }

    @Test
    fun polygonCutAtCornersIsTheSameAsTheOriginalPolygon() {
        val square = Rectangle(0.0, 0.0, 10.0, 10.0)
        square
            .cut(0.0, 0.25, 0.5, 0.75)
            .toPolygon()
            .apply { assertEquals(square.points, this.points) }
    }
}
