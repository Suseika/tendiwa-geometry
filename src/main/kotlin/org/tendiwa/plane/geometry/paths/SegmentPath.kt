package org.tendiwa.plane.geometry.paths

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.shapes.SegmentGroup
import org.tendiwa.plane.geometry.trails.Trail
import org.tendiwa.tools.argumentConstraint

/**
 * A line of segment that may contain the same point twice. Thus, it may
 * be equivalent to a [Polyline] or a [Polygon].
 */
class SegmentPath(override val points: List<Point>) : SegmentGroup {
    init {
        argumentConstraint(
            points,
            { it.size > 1 },
            { "point list must contain at least 2 points" }
        )
    }

    override val segments: List<Segment>
        get() = points
            .dropLast(1)
            .mapIndexed { i, point -> Segment(point, points[i + 1]) }

    fun isClosed(): Boolean =
        points[0] == points.last()

    fun isOpen(): Boolean =
        !isClosed()
}

fun SegmentPath(start: Point, operations: Trail.() -> Unit): SegmentPath =
    SegmentPath(Trail(start).apply(operations).points)
