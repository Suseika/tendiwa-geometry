package org.tendiwa.plane.geometry.segments.multi

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.segments.Segment

/**
 * Segment divided into smaller consecutive segment by cutting it at
 * particular points.
 * <pre>O-----*--*----*----*-*--O</pre>
 * Os are segment's ends, and *s are points — kebablets.
 */
interface Multisegment {
    /**
     * Segment where the [cuts] lie.
     */
    val original: Segment

    /**
     * The points that lie on [original] segment and form [subsegments].
     *
     */
    val cuts: List<Point>
        get() = subsegments.dropLast(1).map { it.end }

    /**
     * Segments into which the original [original] is partitioned. Endpoints
     * of those segments are either [cuts] or endpoints of the original
     * [original].
     */
    val subsegments: List<Segment>
}
