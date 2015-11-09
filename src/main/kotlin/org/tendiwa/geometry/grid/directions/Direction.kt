package org.tendiwa.geometry.grid.directions

interface Direction {
    val dx: Int
    val dy: Int
    val cw8: Direction
    val cw4: Direction
    val ccw8: Direction
    val ccw4: Direction
    val opposite: Direction
}
