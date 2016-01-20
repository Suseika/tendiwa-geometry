package org.tendiwa.plane.geometry.polygons

import org.tendiwa.collections.loopedLinks
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.shapes.SegmentGroup
import org.tendiwa.plane.geometry.trails.Trail

/**
 * A polygon.
 */
interface Polygon : SegmentGroup {
    override val points: List<Point>
    /**
     * Segments between consecutive points. For each segment, it must be true
     * that `this.end == nextSegment.start`, assuming nextSegment for
     * `segments.last()` is `segments[0]`
     */
    override val segments: List<Segment>
        get() = points.loopedLinks.map { Segment(it.first, it.second) }

    /**
     * Returns true if the points of this [Polygon] go clockwise, or false
     * otherwise.
     */
    fun isClockwise(): Boolean =
        segments
            .map { (it.end.x - it.start.x) / (it.end.y + it.start.y) }
            .sum()
            .apply { assert(this != 0.0) }
            .run { this > 0.0 }
}

fun Polygon(point: Point, movements: Trail.() -> Unit): Polygon =
    Polygon(Trail(point).apply(movements).points)
