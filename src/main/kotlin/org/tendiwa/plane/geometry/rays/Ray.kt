package org.tendiwa.plane.geometry.rays

import org.tendiwa.plane.directions.Direction
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.segments.vector
import org.tendiwa.plane.geometry.vectors.direction

/**
 * [Ray on Wikipedia](https://en.wikipedia.org/wiki/Line_(geometry)#Ray)
 * @param start Beginning of the ray.
 * @param direction Direction in radians.
 */
data class Ray(val start: Point, val direction: Direction) {
    constructor(guide: Segment) : this(guide.start, guide.vector.direction)
}
