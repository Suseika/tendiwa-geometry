package org.tendiwa.geometry.points

import org.tendiwa.math.doubles.isCloseToZero

infix fun Point.reallyCloseTo(another: Point): Boolean =
    (this.x - another.x).isCloseToZero && (this.y - another.y).isCloseToZero

fun comparePointsLinewise(a: Point, b: Point): Int {
    val signum = Math.signum(a.x - b.x).toInt();
    if (signum == 0) {
        return Math.signum(a.y - b.y).toInt();
    }
    return signum;
}

/**
 * Returns squared distance to some point.
 *
 * This method has better performance than [Point.distanceTo] because it
 * doesn't have to compute a square root; see
 * [Point-to-Point Distance](http://mathworld.wolfram.com/Point-PointDistance2-Dimensional.html).
 *
 * Optimizations come from the fact that:
 *
 * `(a squaredDistanceTo b).compareTo(a squaredDistanceTo c)`
 *
 * is equivalent to:
 *
 * `(a distanceTo b).compareTo(a distanceTo c)`
 */
infix fun Point.squaredDistanceTo(target: Point): Double =
    (target.x - this.x) * (target.x - this.x) + (target.y - this.y) * (target.y - this.y)
