package org.tendiwa.plane.geometry.polygons.masked

import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.tendiwa.math.sliders.CircularSlider
import org.tendiwa.plane.geometry.polygons.masked.PerimeterPiece
import org.tendiwa.tools.expectIllegalArgument

class PerimeterPieceTest {
    @JvmField @Rule val expectRule = ExpectedException.none()

    @Test
    fun `fails if radius is LTE 0`() {
        expectRule.expectIllegalArgument(
            "radius must be > 0.0"
        )
        PerimeterPiece(CircularSlider(0.0), -1.0)
    }
}
