package org.tendiwa.geometry.polygons

import org.tendiwa.collections.loopedLinks
import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.segments.Segment
import org.tendiwa.geometry.shapes.SegmentGroup

/**
 * A polygon.
 */
interface Polygon : SegmentGroup {
    override val points: List<Point>
    override val segments: List<Segment>
        get() = points.loopedLinks.map { Segment(it.first, it.second) }
}
