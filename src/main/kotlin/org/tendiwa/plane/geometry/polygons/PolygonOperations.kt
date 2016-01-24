package org.tendiwa.plane.geometry.polygons

import org.tendiwa.collections.nextAfter
import org.tendiwa.collections.prevBefore
import org.tendiwa.plane.directions.DirectionFan
import org.tendiwa.plane.geometry.angles.Angle
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.directionTo
import org.tendiwa.plane.geometry.rectangles.contains
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.tools.argumentsConstraint

fun Polygon.toClockwise(): ClockwisePolygon =
    when (isClockwise()) {
        true -> ClockwisePolygon(points)
        false -> ClockwisePolygon(points.reversed())
    }

/**
 * Checks if a [point] is inside the polygon.
 *
 * If a point is very close to the polygon's border, then the result is
 * undefined because of inevitable rounding errors.
 * @param point The point to check.
 */
fun Polygon.contains(point: Point): Boolean =
    if (!hull.contains(point)) {
        false
    } else {
        // Algorithm described in http://stackoverflow.com/a/2922778/1542343
        points.indices
            .fold(
                false,
                { encloses, index ->
                    encloses xor enclosementChanges(
                        tested = point,
                        current = points[index],
                        previous = points.prevBefore(index)
                    )
                }
            )
    }

private fun enclosementChanges(
    tested: Point,
    current: Point,
    previous: Point
): Boolean =
    (current.y > tested.y != previous.y > tested.y) &&
        tested.x < (previous.x - current.x) * (tested.y - current.y) /
            (previous.y - current.y) + current.x

fun Polygon.segment(index: Int): Segment {
    argumentsConstraint(
        index >= 0 && index < points.size,
        {
            "index must be a valid index of a polygon point; " +
                "index is $index, points.size is ${points.size}"
        }
    )
    return Segment(points[index], points.nextAfter(index))
}

/**
 * Returns a corner of this polygon.
 *
 * @param index Index of a point of this polygon at which the corner is
 * located.
 * @param inward Whether the corner faces inside the polygon (the actual
 * corner of a polygon), or outside of the polygon (PI*2 minus the
 * actual corner).
 */
fun Polygon.corner(index: Int, inward: Boolean = true): Angle {
    argumentsConstraint(
        index in 0..points.lastIndex,
        {
            "index must be a valid index of polygon point; index is $index, " +
                "points.size is ${points.size}"
        }
    )
    return angleAtCorner(index, inward)
}

private fun Polygon.angleAtCorner(index: Int, inward: Boolean = true): Angle {
    val toNext = directionToNextPoint(index)
    val toPrevious = directionToPreviousPoint(index)
    val toRight = inwardCornerIsToTheRight(inward)
    return Angle(
        points[index],
        DirectionFan(
            if (toRight) toPrevious else toNext,
            if (toRight) toNext else toPrevious
        )
    )
}

private fun Polygon.directionToPreviousPoint(index: Int) =
    points[index] directionTo points.prevBefore(index)

private fun Polygon.directionToNextPoint(index: Int) =
    points[index] directionTo points.nextAfter(index)

/**
 * Checks if inward corners of this polygon are left or right if you move
 * polygonwise.
 */
fun Polygon.inwardCornerIsToTheRight(inward: Boolean): Boolean =
    !isClockwise() xor inward

/**
 * Retruns all corners at points of this polygon.
 * @param inward Whether to return actual corners (inward = true) or their
 * outward counterparts (PI*2 minus the actual corner, inward = false)
 */
fun Polygon.corners(inward: Boolean = true): List<Angle> =
    points.indices.map {
        index ->
        angleAtCorner(index, inward)
    }

/**
 * Tells if the inside of the polygon is left from its edges or right.
 * @return true if right, false if left.
 */
fun Polygon.insideIsRight(): Boolean =
    isClockwise()

