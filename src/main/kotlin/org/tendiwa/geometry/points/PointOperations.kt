package org.tendiwa.geometry.points

import org.tendiwa.math.constants.EPSILON

infix fun Point.reallyCloseTo(another: Point) : Boolean =
    this distanceTo another < EPSILON

