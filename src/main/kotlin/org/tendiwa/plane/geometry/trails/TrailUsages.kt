package org.tendiwa.plane.geometry.trails

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.polygons.Polygon
import org.tendiwa.plane.geometry.polylines.Polyline

val Trail.polygon: Polygon
    get() = Polygon(points)

val Trail.polyline: Polyline
    get() = Polyline(points)

fun Polyline(x: Double, y: Double, movements: Trail.() -> Unit): Polyline =
    Polyline(Point(x, y), movements)

fun Polyline(point: Point, movements: Trail.() -> Unit): Polyline =
    Trail(point).apply(movements).polyline

// TODO: Remove this method in favor of the next one
fun Polygon(x: Double, y: Double, movements: Trail.() -> Unit): Polygon =
    Trail(x, y).apply(movements).polygon

fun Polygon(point: Point, movements: Trail.() -> Unit): Polygon =
    Trail(point).apply(movements).polygon
