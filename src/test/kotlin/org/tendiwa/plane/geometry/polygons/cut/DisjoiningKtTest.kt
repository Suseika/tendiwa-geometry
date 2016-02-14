package org.tendiwa.plane.geometry.polygons.cut

import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.tendiwa.plane.geometry.paths.length
import org.tendiwa.plane.geometry.polygons.perimeter
import org.tendiwa.plane.geometry.rectangles.Rectangle
import org.tendiwa.tools.assertAlmostEquals
import org.tendiwa.tools.expectIllegalArgument
import kotlin.test.assertEquals

class DisjoiningKtTest {
    @JvmField @Rule val expectRule = ExpectedException.none()

    @Test
    fun disjoin() {
        val polygon = Rectangle(0.0, 0.0, 10.0, 10.0)
        polygon
            .cut(0.2, 0.8)
            .disjoin()
            .apply {
                assertEquals(2, size)
                assertAlmostEquals(
                    polygon.perimeter,
                    this.map { it.length }.sum()
                )
            }
    }

    @Test
    fun `fails to disjoin if the number of cuts is 0`() {
        expectRule.expectIllegalArgument(
            "CutPolygon should contain an even number of cuts that is > 0"
        )
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .cut()
            .disjoin()
    }

    @Test
    fun `fails to disjoin if the number of cuts is odd`() {
        expectRule.expectIllegalArgument(
            "CutPolygon should contain an even number of cuts that is > 0"
        )
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .cut(0.1, 0.2, 0.3)
            .disjoin()
    }
}
