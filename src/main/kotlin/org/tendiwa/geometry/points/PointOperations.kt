package org.tendiwa.geometry.points

import org.tendiwa.geometry.EPSILON

infix fun Point.reallyCloseTo(another: Point) : Boolean =
    this distanceTo another < EPSILON

