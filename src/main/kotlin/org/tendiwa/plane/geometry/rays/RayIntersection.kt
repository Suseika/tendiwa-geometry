package org.tendiwa.plane.geometry.rays

import org.tendiwa.math.constants.EPSILON
import org.tendiwa.plane.geometry.exceptions.GeometryException
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.relativeTo
import org.tendiwa.plane.geometry.segments.Segment

/**
 * Finds intersection of two *rays*, both defined by the start of a ray and
 * some other point on that ray.
 * Note that, if rays intersect, it doesn't mean that segments by which those
 * rays are defined intersect.
 */
// TODO: This class is inconsistently designed, refactor it
class RayIntersection(
    private val sourceNode: Point,
    private val targetPoint: Point,
    segment: Segment
) {
    val intersects: Boolean
    /**
     * Relative distance from start of the first ray to intersection point, 0.0
     * means intersection is at `sourceNode`, 1.0 means it's at target
     * point. Note that `r` is computed even if rays are parallel, in
     * which case `r == Infinity`.
     */
    val r: Double

    val s: Double

    init {
        if (sourceNode == targetPoint) {
            throw IllegalArgumentException("There can't be zero distance between points")
        }
        if (segment.start == segment.end) {
            throw IllegalArgumentException("Segment can't be zero length")
        }

        val ab = targetPoint.relativeTo(sourceNode)
        val cd = segment.end.relativeTo(
            segment.start)
        val denom = (ab.x * cd.y) - (ab.y * cd.x)
        // TODO: Is computation of parallel rays needed or not?
        //		if (denom == 0) {
        //			throw new GeometryException(
        //				"Rays " + new Segment(sourceNode, targetPoint) + " and " + segment + " are  parallel"
        //			);
        //		}
        val ca = sourceNode.relativeTo(
            segment.start)
        r = ((ca.y * cd.x) - (ca.x * cd.y)) / denom
        s = ((ca.y * ab.x) - (ca.x * ab.y)) / denom
        intersects = (denom != 0.0) && !(r == 0.0 && s == 0.0)
    }

    // TODO: Move to the Segment class
    constructor(a: Segment, b: Segment) : this(a.start, a.end, b) {
    }

    fun commonPoint(): Point {
        if (!intersects) {
            throw GeometryException("Trying to find intersection point of two parallel lines")
        }
        assert(java.lang.Double.isFinite(r))
        return Point(
            sourceNode.x + (targetPoint.x - sourceNode.x) * r,
            sourceNode.y + (targetPoint.y - sourceNode.y) * r)
    }

    fun segmentsIntersect(): Boolean =
        r > EPSILON && r < ALMOST_1 && s > EPSILON && s < ALMOST_1

    companion object {
        private val ALMOST_1 = 1 - EPSILON
    }
}
