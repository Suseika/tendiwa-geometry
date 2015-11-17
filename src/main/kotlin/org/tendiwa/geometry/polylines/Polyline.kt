package org.tendiwa.geometry.polylines

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.segments.Segment
import org.tendiwa.geometry.shapes.SegmentGroup

interface Polyline : SegmentGroup {
    override val points: List<Point>
    override val segments: List<Segment>
        get() = points
            .dropLast(1)
            .mapIndexed { i, point -> Segment(point, points[i + 1]) }
}
