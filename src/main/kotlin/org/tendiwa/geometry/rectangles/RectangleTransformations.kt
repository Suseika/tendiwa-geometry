package org.tendiwa.geometry.rectangles

fun Rectangle.move(dx: Double, dy: Double): Rectangle =
    Rectangle(x + dx, y + dy, width, height)

