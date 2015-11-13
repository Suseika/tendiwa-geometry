package org.tendiwa.geometry.grid.rectangles

import org.tendiwa.geometry.grid.masks.BoundedGridMask

/**
 * An axis-parallel rectangle over points in ℤ×ℤ.
 * @property x X coordinate of the top left corner.
 * @property y Y coordinate of the top left corner.
 * @property width Width.
 * @property height Height.
 */

interface GridRectangle : BoundedGridMask {
    val x: Int
    val y: Int
    val width: Int
    val height: Int
}
