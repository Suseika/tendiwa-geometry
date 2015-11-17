package org.tendiwa.geometry.points

import org.tendiwa.math.doubles.isCloseToZero

infix fun Point.reallyCloseTo(another: Point): Boolean =
    (this.x - another.x).isCloseToZero && (this.y - another.y).isCloseToZero

