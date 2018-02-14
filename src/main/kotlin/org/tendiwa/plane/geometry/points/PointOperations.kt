package org.tendiwa.plane.geometry.points

import org.tendiwa.math.doubles.isCloseToZero
import org.tendiwa.plane.directions.Direction
import org.tendiwa.plane.geometry.rays.Ray
import org.tendiwa.plane.geometry.rectangles.Rectangle
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.segments.dx
import org.tendiwa.plane.geometry.segments.dy
import org.tendiwa.plane.geometry.vectors.Vector
import org.tendiwa.plane.geometry.vectors.direction

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

infix fun Point.segmentTo(target: Point): Segment =
    Segment(this, target)

infix fun Point.lineThrough(target: Point): org.tendiwa.plane.geometry.lines.Line =
    org.tendiwa.plane.geometry.lines.Line(
        this.y - target.y,
        target.x - this.x,
        (this.x - target.x) * this.y + (target.y - this.y) * this.x
    )

infix fun Point.vectorTo(target: Point): org.tendiwa.plane.geometry.vectors.Vector =
    org.tendiwa.plane.geometry.vectors.Vector(target.x - this.x, target.y - this.y)

/**
 * Creates a [Segment] by placing its another end *relative* to this point.
 */
fun Point.spanSegment(dx: Double, dy: Double): Segment =
    Segment(this, this.move(dx, dy))

/**
 * Creates a [Segment] by placing its another end *relative* to this point.
 */
fun Point.spanSegment(d: Vector): Segment =
    Segment(this, this.move(d.x, d.y))

fun Point.spanSegment(direction: org.tendiwa.plane.directions.KingDirection, distance: Double): Segment =
    Segment(this, this.moveKing(direction, distance))

fun Point.spanHorizontalSegment(dx: Double): Segment =
    Segment(this, this.move(dx, 0.0))

fun Point.spanVerticalSegment(dy: Double): Segment =
    Segment(this, this.move(0.0, dy))

infix fun Point.spanRectangle(other: Point): Rectangle {
    val minX = Math.min(this.x, other.x)
    val minY = Math.min(this.y, other.y)
    val maxX = Math.max(this.x, other.x)
    val maxY = Math.max(this.y, other.y)
    return Rectangle(
        minX,
        minY,
        maxX - minX,
        maxY - minY
    )
}
/**
 * @param segment Segment that defines a line.
 * @return Distance to the line defined by `segment`.
 */
fun Point.distanceToLine(segment: Segment): Double {
    val dx = segment.end.x - segment.start.x;
    val dy = segment.end.y - segment.start.y;
    val normalLength = Math.sqrt(dx * dx + dy * dy);
    return Math.abs(
        (this.x - segment.start.x) * dy
            - (this.y - segment.start.y) * dx
    ) / normalLength;
}
fun Point.isLeftOf(segment: Segment): Boolean =
    segment.dx * (y - segment.start.y) - segment.dy * (x - segment.start.x) > 0

infix fun Point.directionTo(other: Point): Direction =
    (this vectorTo other).direction

infix fun Point.rayThrough(other: Point): Ray =
    Ray(
        this,
        this directionTo other
    )
