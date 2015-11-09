package org.tendiwa.geometry.continuum.points

import org.tendiwa.geometry.continuum.EPSILON

infix fun Point.reallyCloseTo(another: Point) : Boolean =
    this distanceTo another < EPSILON

