package org.tendiwa.geometry.bends

import org.tendiwa.geometry.constructors.vectorTo

val Bend.isStraight: Boolean
    get() = start.vectorTo(middle).run { x / y } == middle.vectorTo(end).run { x / y }
