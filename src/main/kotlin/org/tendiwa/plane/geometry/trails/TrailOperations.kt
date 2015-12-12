package org.tendiwa.plane.geometry.trails

import org.tendiwa.plane.geometry.points.Point

fun Trail.moveTo(x: Double, y: Double) {
    this.moveTo(Point(x, y))
}


