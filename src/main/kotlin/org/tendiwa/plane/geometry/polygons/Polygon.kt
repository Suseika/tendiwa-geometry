package org.tendiwa.plane.geometry.polygons

import org.tendiwa.collections.loopedLinks
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.shapes.SegmentGroup

/**
 * A polygon.
 */
interface Polygon : SegmentGroup {
    override val points: List<Point>
    override val segments: List<Segment>
        get() = points.loopedLinks.map { Segment(it.first, it.second) }
}
