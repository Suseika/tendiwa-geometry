package org.tendiwa.plane.geometry.rays

import org.tendiwa.plane.geometry.points.Point

/**
 * [Ray on Wikipedia](https://en.wikipedia.org/wiki/Line_(geometry)#Ray)
 * @param start Beginning of the ray.
 * @param direction Direction in radians.
 */
data class Ray(val start: Point, val direction: Double)
