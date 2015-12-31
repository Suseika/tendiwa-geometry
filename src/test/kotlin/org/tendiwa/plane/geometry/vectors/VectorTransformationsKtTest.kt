package org.tendiwa.plane.geometry.vectors

import org.junit.Test
import java.lang.Double.doubleToLongBits
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class VectorTransformationsKtTest {
    @Test
    fun vectorCanHaveNegativeZeroComponent() {
        Vector(-0.0, 1.0)
            .apply {
                assertNotEquals(
                    doubleToLongBits(0.0),
                    doubleToLongBits(x)
                )
                assertEquals(
                    doubleToLongBits(-0.0),
                    doubleToLongBits(x)
                )
            }
    }
    @Test
    fun toPositiveZeroVector() {
        Vector(-0.0, -0.0).toPositiveZeroVector()
            .apply {
                assertEquals(
                    doubleToLongBits(0.0),
                    doubleToLongBits(x)
                )
                assertEquals(
                    doubleToLongBits(0.0),
                    doubleToLongBits(y)
                )
            }
    }
}
