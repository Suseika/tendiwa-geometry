package org.tendiwa.plane.geometry.scorchedPolygon

import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.tendiwa.math.sliders.CircularMask
import org.tendiwa.math.sliders.CircularSlider
import org.tendiwa.math.sliders.Slider1Sphere
import org.tendiwa.math.sliders.Slider1Sphere.Size
import org.tendiwa.plane.geometry.polygons.masked.Scorch
import org.tendiwa.plane.geometry.polygons.masked.mask
import org.tendiwa.plane.geometry.polygons.masked.scorch
import org.tendiwa.plane.geometry.rectangles.Rectangle
import kotlin.test.assertEquals

class MaskedPolygonKtTest {
    @JvmField @Rule val expectRule = ExpectedException.none()

    @Test
    fun `number of masked and unmasked is the same if none of them is 0`() {
        val intersecting1 = Slider1Sphere(
            CircularSlider(0.1),
            Size(0.2)
        )
        val intersecting2 = Slider1Sphere(
            CircularSlider(0.2),
            Size(0.2)
        )
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .mask(
                CircularMask(
                    listOf(intersecting1, intersecting2)
                )
            )
            .apply {
                assertEquals(1, masked.size)
                assertEquals(1, unmasked.size)
            }
    }

    @Test
    fun `non-intersecting scorches increase numbers of burns and unburns by 1`() {
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .scorch(
                listOf(
                    Scorch(
                        CircularSlider(0.1),
                        9.0
                    ),
                    Scorch(
                        CircularSlider(0.6),
                        10.0
                    )
                )
            )
            .apply {
                assertEquals(2, masked.size)
                assertEquals(2, unmasked.size)
            }
    }

}
