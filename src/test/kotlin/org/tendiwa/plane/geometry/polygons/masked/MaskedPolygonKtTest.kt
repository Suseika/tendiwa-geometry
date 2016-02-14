package org.tendiwa.plane.geometry.polygons.masked

import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.tendiwa.math.sliders.CircularMask
import org.tendiwa.math.sliders.CircularSlider
import org.tendiwa.math.sliders.Slider1Sphere
import org.tendiwa.math.sliders.Slider1Sphere.Size
import org.tendiwa.plane.geometry.polygons.Polygon
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
            .mask(
                CircularMask(
                    listOf(
                        Slider1Sphere(
                            CircularSlider(0.1),
                            Size(0.2)
                        ),
                        Slider1Sphere(
                            CircularSlider(0.6),
                            Size(0.2)
                        )
                    )
                )
            )
            .apply {
                assertEquals(2, masked.size)
                assertEquals(2, unmasked.size)
            }
    }

    @Test
    fun `completely masked polygon`() {
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .mask(
                CircularMask(
                    listOf(
                        Slider1Sphere(
                            CircularSlider(0.4),
                            Size.MAX
                        )
                    )
                )
            )
            .apply {
                assert(masked.single() is Polygon)
                assert(unmasked.isEmpty())
            }
    }

    @Test
    fun `completely unmasked polygon`() {
        Rectangle(0.0, 0.0, 10.0, 10.0)
            .mask(
                CircularMask(listOf())
            )
            .apply {
                assert(masked.isEmpty())
                assert(unmasked.single() is Polygon)
            }
    }
}
