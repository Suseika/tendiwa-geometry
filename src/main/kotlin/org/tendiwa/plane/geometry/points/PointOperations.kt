package org.tendiwa.plane.geometry.points

import org.tendiwa.math.doubles.isCloseToZero

infix fun org.tendiwa.plane.geometry.points.Point.reallyCloseTo(another: org.tendiwa.plane.geometry.points.Point): Boolean =
    (this.x - another.x).isCloseToZero && (this.y - another.y).isCloseToZero

fun comparePointsLinewise(a: org.tendiwa.plane.geometry.points.Point, b: org.tendiwa.plane.geometry.points.Point): Int {
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
infix fun org.tendiwa.plane.geometry.points.Point.squaredDistanceTo(target: org.tendiwa.plane.geometry.points.Point): Double =
    (target.x - this.x) * (target.x - this.x) + (target.y - this.y) * (target.y - this.y)

infix fun org.tendiwa.plane.geometry.points.Point.segmentTo(target: org.tendiwa.plane.geometry.points.Point): org.tendiwa.plane.geometry.segments.Segment =
    org.tendiwa.plane.geometry.segments.Segment(this, target)

infix fun org.tendiwa.plane.geometry.points.Point.lineThrough(target: org.tendiwa.plane.geometry.points.Point): org.tendiwa.plane.geometry.lines.Line =
    org.tendiwa.plane.geometry.lines.Line(
        this.y - target.y,
        target.x - this.x,
        (this.x - target.x) * this.y + (target.y - this.y) * this.x
    )

infix fun org.tendiwa.plane.geometry.points.Point.vectorTo(target: org.tendiwa.plane.geometry.points.Point): org.tendiwa.plane.geometry.vectors.Vector =
    org.tendiwa.plane.geometry.vectors.Vector(target.x - this.x, target.y - this.y)

/**
 * Creates a [Segment] by placing its another end *relative* to this point.
 */
fun org.tendiwa.plane.geometry.points.Point.spanSegment(dx: Double, dy: Double): org.tendiwa.plane.geometry.segments.Segment =
    org.tendiwa.plane.geometry.segments.Segment(this, this.move(dx, dy))

fun org.tendiwa.plane.geometry.points.Point.spanSegment(direction: org.tendiwa.plane.directions.Direction, distance: Double): org.tendiwa.plane.geometry.segments.Segment =
    org.tendiwa.plane.geometry.segments.Segment(this, this.moveKing(direction, distance))

fun org.tendiwa.plane.geometry.points.Point.spanHorizontalSegment(dx: Double): org.tendiwa.plane.geometry.segments.Segment =
    org.tendiwa.plane.geometry.segments.Segment(this, this.move(dx, 0.0))

fun org.tendiwa.plane.geometry.points.Point.spanVerticalSegment(dy: Double): org.tendiwa.plane.geometry.segments.Segment =
    org.tendiwa.plane.geometry.segments.Segment(this, this.move(0.0, dy))
