package org.tendiwa.geometry.rectangles

fun Rectangle.move(dx: Double, dy: Double): Rectangle =
    Rectangle(x + dx, y + dy, width, height)

fun Rectangle.shrink(d: Double): Rectangle =
    Rectangle(x + d, y + d, width - d * 2, height - d * 2)

fun Rectangle.grow(d: Double): Rectangle =
    Rectangle(x - d, y - d, width + d * 2, height + d * 2)

