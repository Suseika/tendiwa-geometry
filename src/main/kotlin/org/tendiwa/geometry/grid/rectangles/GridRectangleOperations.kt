package org.tendiwa.geometry.grid.rectangles

fun GridRectangle.contains(x: Int, y: Int) =
    (x in this.x..this.maxX) && (y in this.x..this.maxY)

fun GridRectangle.shrink(amount: Int): GridRectangle {
    if (amount > width || amount > height) {
        throw IllegalArgumentException(
            "Rectangle of area $size can't be shrinked by $amount"
        )
    }
    return GridRectangle(
        x + amount,
        y + amount,
        width - amount,
        height - amount
    )
}
