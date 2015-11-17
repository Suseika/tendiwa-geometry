package org.tendiwa.geometry.trails

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.polygons.Polygon
import org.tendiwa.geometry.polylines.Polyline

val Trail.polygon: Polygon
    get() = Polygon(points)

val Trail.polyline: Polyline
    get() = Polyline(points)

fun Polyline(x: Double, y: Double, movements: Trail.() -> Unit): Polyline =
    Polyline(Point(x, y), movements)

fun Polyline(point: Point, movements: Trail.() -> Unit): Polyline =
    Trail(point).apply(movements).polyline

fun Polygon(x: Double, y: Double, movements: Trail.()-> Unit): Polygon =
    Trail(x, y).apply(movements).polygon
