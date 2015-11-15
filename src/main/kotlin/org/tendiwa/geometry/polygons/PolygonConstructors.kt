package org.tendiwa.geometry.polygons

import org.tendiwa.geometry.points.Point

fun Polygon(vararg points: Point): Polygon =
    DefaultPolygon(points.asList())

fun Polygon(points: List<Point>): Polygon =
    DefaultPolygon(points)

private data class DefaultPolygon(override val points: List<Point>) : Polygon
