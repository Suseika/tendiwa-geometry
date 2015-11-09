package org.tendiwa.geometry.grid.rectangles

/**
 * X coordinate of the right side of the rectangle.
 */
val GridRectangle.maxX: Int
    get() = x + width - 1

/**
 * Y coordinate of the bottom side of the rectangle.
 */
val GridRectangle.maxY: Int
    get() = y + height - 1

/**
 * Area of a rectangle.
 */
val GridRectangle.area: Int
    get() = width * height

/**
 * Range from [GridRectangle.x] to [GridRectangle.maxX].
 */
val GridRectangle.xAxisRange: IntRange
    get() = (x..maxX)

/**
 * Range from [GridRectangle.y] to [GridRectangle.maxY].
 */
val GridRectangle.yAxisRange: IntRange
    get() = (y..maxY)

/**
 * Returns width or height of a rectangle, whichever is the greatest.
 */
val GridRectangle.maxDimension: Int
    get() = Math.max(width, height)

/**
 * Returns width or height of a rectangle, whichever is the greatest.
 */
val GridRectangle.minDimension: Int
    get() = Math.min(width, height)
