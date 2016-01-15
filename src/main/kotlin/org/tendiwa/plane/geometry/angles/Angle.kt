package org.tendiwa.plane.geometry.angles

import org.tendiwa.plane.directions.Direction
import org.tendiwa.plane.geometry.points.Point

/**
 * Figure formed by two rays, called the sides of the angle.
 */
data class Angle
/**
 * @param point Beginning of both rays.
 * @param cw Direction of the clockwise ray.
 * @param ccw Direction of the counter-clockwise ray.
 */
(
    val point: Point,
    val cw: Direction,
    val ccw: Direction
)
