package org.tendiwa.plane.geometry.segments.multi

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.segments.Segment

/**
 * [Multisegment] split into exactly two parts.
 */
class Bisegment(
    override val original: Segment,
    kebablet: Point
) : Multisegment {
    /**
     * First part of the multisegment.
     *
     * The following conditions are invariant:
     * - `firstHalf.end == secondHalf.start`
     * - `firstHalf.start == segment.start`
     */
    val firstHalf = Segment(original.start, kebablet)

    /**
     * Second part of the multisegment.
     *
     * The following conditions are invariant:
     * - `secondHalf.start == firstHalf.end`
     * - `secondHalf.end == segment.end`
     */
    val secondHalf = Segment(kebablet, original.end)

    /**
     * The only [cut|cuts] of this [Multisegment].
     */
    val cut: Point
        get() = firstHalf.end

    override val subsegments: List<Segment>
        get() = listOf(firstHalf, secondHalf)

    override val cuts: List<Point>
        get() = listOf(cut)
}
