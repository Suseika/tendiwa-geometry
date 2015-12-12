package org.tendiwa.plane.geometry.bends

import org.tendiwa.plane.geometry.points.vectorTo


val Bend.isStraight: Boolean
    get() = start.vectorTo(middle).run { x / y } == middle.vectorTo(end).run { x / y }
