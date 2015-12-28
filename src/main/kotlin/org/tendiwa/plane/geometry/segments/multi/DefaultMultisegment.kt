package org.tendiwa.plane.geometry.segments.multi

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.segments.Segment

/**
 * [Multisegment] with 0 or more cut points.
 */
// TODO: Replace this class with function Multisegment
class DefaultMultisegment(
    segment: Segment,
    cuts: List<Point>
) : Multisegment by MutableMultisegment(segment, cuts)
