package org.tendiwa.geometry.polylines

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.shapes.Shape

interface Polyline : Shape {
    override val points: List<Point>
}
