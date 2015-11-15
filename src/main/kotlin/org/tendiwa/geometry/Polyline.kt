package org.tendiwa.geometry

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.shapes.Shape

data class Polyline(override val points: List<Point>) : Shape
