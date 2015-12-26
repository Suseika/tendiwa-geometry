package org.tendiwa.plane.geometry.sliders

/**
 * Returns the shortest of two possible distances between this slider and
 * another slider.
 */
fun CircularSlider.shortestDistanceTo(target: CircularSlider): Double =
    Math.min(
        forwardDx(target),
        backwardDx(target)
    )

fun CircularSlider.forwardDx(target: CircularSlider): Double =
    when {
        target.position > this.position -> target.position - this.position
        else -> target.position + 1.0 - this.position
    }

fun CircularSlider.backwardDx(target: CircularSlider): Double =
    when {
        target.position < this.position -> this.position - target.position
        else -> this.position + 1.0 - target.position
    }

/**
 * Create a new slider in the middle between this one and a target slider.
 * @param target Target slider.
 */
fun CircularSlider.moveHalfwayTowards(target: CircularSlider): CircularSlider {
    val forward = forwardDx(target)
    val backward = backwardDx(target)
    return when {
        forward < backward -> CircularSlider((position + forward / 2) % 1.0)
        else -> CircularSlider((position - backward / 2)
            .run { if (this < 0) 1.0 + this else this })
    }
}

fun CircularSlider.forwardRange(target: CircularSlider): ClosedRange<Double> =
    position
        .rangeTo(position + forwardDx(target))
        .apply { assert(start < endInclusive) }

infix fun CircularSlider.goesBefore(other: CircularSlider): Boolean =
    this.position < other.position || other.position == 0.0

