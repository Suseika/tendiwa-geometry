package org.tendiwa.plane.geometry.sliders

/**
 * Point in a looped one-dimensional coordinate system with possible coordinates
 * in range *[0.0..1.0)*.
 */
public data class CircularSlider(val position: Double) {
    init {
        if (position < 0.0 || position >= 1.0) {
            throw IllegalArgumentException(
                "position must be in [0..1); it is $position"
            )
        }
    }
}
