package org.tendiwa.plane.geometry.rectangles

import org.tendiwa.plane.directions.CardinalDirection
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.segments.Segment

fun Rectangle.contains(point: Point): Boolean =
    point.x in x..maxX && point.y in y..maxY

fun Rectangle.strictlyContains(point: Point): Boolean =
    point.x > x && point.x < maxX && point.y > y && point.y < maxY

fun Rectangle.side(direction: CardinalDirection): Segment =
    when (direction) {
        CardinalDirection.N -> segments[0]
        CardinalDirection.E -> segments[1]
        CardinalDirection.S -> segments[2]
        CardinalDirection.W -> segments[3]
    }

fun Rectangle.pointAtRatio(xRatio: Double, yRatio: Double) =
    Point(x + width * xRatio, y + height * yRatio)
