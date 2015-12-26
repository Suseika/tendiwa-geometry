package org.tendiwa.plane.geometry.sliders

import org.junit.Assert
import org.junit.Test
import org.tendiwa.math.constants.EPSILON

class CircularSliderTest {
    @Test
    fun forwardDistance() {
        Assert.assertEquals(
            0.1,
            CircularSlider(0.8).forwardDx(CircularSlider(0.9)),
            EPSILON
        )
    }

    @Test
    fun forwardDistanceOverBeginning() {
        Assert.assertEquals(
            0.2,
            CircularSlider(0.9).forwardDx(CircularSlider(0.1)),
            EPSILON
        )
    }

    @Test
    fun backwardDistanceOverBeginning() {
        Assert.assertEquals(
            0.2,
            CircularSlider(0.1).backwardDx(CircularSlider(0.9)),
            EPSILON
        )
    }

    @Test
    fun backwardDistance() {
        Assert.assertEquals(
            0.3,
            CircularSlider(0.9).backwardDx(CircularSlider(0.6)),
            EPSILON
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun failsToConstructPointWithCoordinateGTE1() {
        CircularSlider(1.1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun failsToConstructPointWithCoordinateLT0() {
        CircularSlider(-0.01)
    }

    @Test
    fun moveHalfwayTowards() {
        Assert.assertEquals(
            0.5,
            CircularSlider(0.4)
                .moveHalfwayTowards(CircularSlider(0.6))
                .position,
            EPSILON
        )
    }

    @Test
    fun moveHalfwayTowardsOverBeginning() {
        Assert.assertEquals(
            0.1,
            CircularSlider(0.9)
                .moveHalfwayTowards(CircularSlider(0.3))
                .position,
            EPSILON
        )
    }
}
