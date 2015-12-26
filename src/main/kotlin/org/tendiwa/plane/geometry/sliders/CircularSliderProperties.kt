package org.tendiwa.plane.geometry.sliders
/**
 * The position of this slider in a slightly different circular coordinate
 * system in range *(0.0..1.0]*.
 *
 * - Alternative position of a slider with position 0.0 is 1.0;
 * - Alternative positions of all other sliders are the same as their
 * [position]'s.
 */
val CircularSlider.alternativePosition: Double
    get() = if (position == 0.0) 1.0 else position


