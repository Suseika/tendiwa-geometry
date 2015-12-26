package org.tendiwa.plane.geometry.sliders

/**
 * Point in a looped one-dimensional coordinate system with possible coordinates
 * in range *[0.0..1.0)*.
 */
public data class CircularSlider(val position: Double) {
    /**
     * The position of this slider in a slightly different circular coordinate
     * system in range *(0.0..1.0]*.
     *
     * - Alternative position of a slider with position 0.0 is 1.0;
     * - Alternative positions of all other sliders are the same as their
     * [position]'s.
     */
    val alternativePosition: Double
        get() = if (position == 0.0) 1.0 else position

    init {
        if (position < 0.0 || position >= 1.0) {
            throw IllegalArgumentException(
                "position must be in [0..1); it is $position"
            )
        }
    }

    /**
     * Returns the shortest of two possible distances between this slider and
     * another slider.
     */
    fun shortestDistanceTo(target: CircularSlider): Double =
        Math.min(
            forwardDx(target),
            backwardDx(target)
        )

    fun forwardDx(target: CircularSlider): Double =
        when {
            target.position > this.position -> target.position - this.position
            else -> target.position + 1.0 - this.position
        }

    fun backwardDx(target: CircularSlider): Double =
        when {
            target.position < this.position -> this.position - target.position
            else -> this.position + 1.0 - target.position
        }

    /**
     * Create a new slider in the middle between this one and a target slider.
     * @param target Target slider.
     */
    fun moveHalfwayTowards(target: CircularSlider): CircularSlider {
        val forward = forwardDx(target)
        val backward = backwardDx(target)
        return when {
            forward < backward -> CircularSlider((position + forward / 2) % 1.0)
            else -> CircularSlider((position - backward / 2)
                .run { if (this < 0) 1.0 + this else this })
        }
    }

    fun forwardRange(target: CircularSlider): ClosedRange<Double> =
        position
            .rangeTo(position + forwardDx(target))
            .apply { assert(start < endInclusive) }

    infix fun goesBefore(other: CircularSlider): Boolean =
        this.position < other.position || other.position == 0.0
}
