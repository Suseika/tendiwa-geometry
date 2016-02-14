package org.tendiwa.plane.geometry.paths

import org.tendiwa.collections.withoutLast
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.shapes.SegmentGroup
import org.tendiwa.plane.geometry.trails.Trail
import org.tendiwa.tools.argumentConstraint

/**
 * A line of segment that may contain the same point twice. Thus, it may
 * be equivalent to a [Polyline] or a [Polygon].
 */
interface SegmentPath : SegmentGroup {
    override val points: List<Point>

    /**
     * Almost same as [points], but it first and last elements are identical
     * in case the [SegmentPath] is closed.
     */
    val steps: List<Point>

    override val segments: List<Segment>
        get() = points
            .dropLast(1)
            .mapIndexed { i, point -> Segment(point, points[i + 1]) }

    fun isClosed(): Boolean =
        steps[0] == steps.last()

    fun isOpen(): Boolean =
        !isClosed()
}

private class GenericSegmentPath(
    override val steps: List<Point>
) : SegmentPath {
    override val points: List<Point>
        get() =
        if (steps.first() == steps.last()) {
            steps.withoutLast()
        } else {
            steps
        }

    init {
        argumentConstraint(
            points,
            { it.size > 1 },
            { "point list must contain at least 2 points" }
        )
    }
}

fun SegmentPath(steps: List<Point>): SegmentPath =
    GenericSegmentPath(steps)

fun SegmentPath(start: Point, operations: Trail.() -> Unit): SegmentPath =
    GenericSegmentPath(Trail(start).apply(operations).points)
