package org.tendiwa.geometry.trails

import org.tendiwa.geometry.points.Point

fun Trail.moveTo(x: Double, y: Double) {
    this.moveTo(Point(x, y))
}


