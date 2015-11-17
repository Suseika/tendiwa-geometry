package org.tendiwa.geometry.polygons

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.shapes.SegmentGroup

/**
 * A polygon.
 */
interface Polygon : SegmentGroup {
    override val points: List<Point>
}
