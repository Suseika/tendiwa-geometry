package org.tendiwa.plane.geometry.segments.multi

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.segments.Segment

/**
 * [Multisegment] with multiple kebablets.
 * @see Multisegment For the explanation of the metaphor of a kebab.
 */
class MultiMultisegment(
    segment: Segment,
    cuts: List<Point>
) : Multisegment by MutableMultisegment(segment, cuts)
