package org.tendiwa.plane.geometry.holeygons

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.polygons.Polygon
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.shapes.SegmentGroup

/**
 * Polygon with holes.
 */
data class Holeygon
/**
 * This constructor doesn't validate that [holes] are actually inside the
 * [enclosing] polygon, because it is very expensive to do so. That can be done
 * separately with [Holeygon.validate] method.
 *
 * @param enclosing Polygon that encloses the [holes].
 * @param holes Holes inside the [enclosing] polygon.
 */
(val enclosing: Polygon, val holes: Collection<Polygon>) : SegmentGroup {
    override val points: Collection<Point>
        get() = enclosing.points + holes.flatMap { it.points }

    override val segments: Collection<Segment>
        get() = enclosing.segments + holes.flatMap { it.segments }
}

val Holeygon.polygons: Collection<Polygon>
    get() = listOf(enclosing) + holes

