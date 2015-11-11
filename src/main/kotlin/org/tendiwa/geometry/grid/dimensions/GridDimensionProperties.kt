package org.tendiwa.geometry.grid.dimensions

/**
 * Returns width or height, whichever is the greatest.
 */
val GridDimension.max: Int
    get() = Math.max(width, height)

/**
 * Returns width or height, whichever is the greatest.
 */
val GridDimension.min: Int
    get() = Math.min(width, height)
