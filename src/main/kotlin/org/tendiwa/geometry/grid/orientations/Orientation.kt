package org.tendiwa.geometry.grid.orientations

enum class Orientation {
    HORIZONTAL, VERTICAL;

    val isVertical: Boolean
        get() = this == VERTICAL

    val isHorizontal: Boolean
        get() = this == VERTICAL

    val reverted: Orientation
        get() = if (this.isVertical) HORIZONTAL else VERTICAL
}
