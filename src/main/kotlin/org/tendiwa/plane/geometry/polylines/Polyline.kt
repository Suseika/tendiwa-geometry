package org.tendiwa.plane.geometry.polylines

import org.tendiwa.plane.geometry.paths.SegmentPath
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.segments.length
import org.tendiwa.plane.geometry.trails.Trail

interface Polyline : SegmentPath {
    override val points: List<Point>

    override val segments: List<Segment>
        get() = points
            .dropLast(1)
            .mapIndexed { i, point -> Segment(point, points[i + 1]) }
}

fun Polyline(point: Point, movements: Trail.() -> Unit): Polyline =
    Polyline(Trail(point).apply(movements).points)

val Polyline.length: Double
    get() =
    segments.map { it.length }.sum()
