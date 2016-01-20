package org.tendiwa.plane.geometry.polylines

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.shapes.SegmentGroup
import org.tendiwa.plane.geometry.trails.Trail

interface Polyline : SegmentGroup {
    override val points: List<Point>
    override val segments: List<Segment>
        get() = points
            .dropLast(1)
            .mapIndexed { i, point -> Segment(point, points[i + 1]) }
}

fun Polyline(point: Point, movements: Trail.() -> Unit): Polyline =
    Polyline(Trail(point).apply(movements).points)
