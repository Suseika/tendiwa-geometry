package org.tendiwa.geometry.rays

import org.tendiwa.geometry.points.Point

/**
 * [Ray on Wikipedia](https://en.wikipedia.org/wiki/Line_(geometry)#Ray)
 * @param start Beginning of the ray.
 * @param direction Direction in radians.
 */
data class Ray(val start: Point, val direction: Double)
