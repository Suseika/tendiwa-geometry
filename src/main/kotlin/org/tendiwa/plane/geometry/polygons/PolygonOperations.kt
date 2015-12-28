package org.tendiwa.plane.geometry.polygons

import org.tendiwa.collections.prevBefore
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.rectangles.contains

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
