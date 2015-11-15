package org.tendiwa.geometry.polygons

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.shapes.Shape

/**
 * A polygon.
 */
data class Polygon(override val points: List<Point>) : Shape
