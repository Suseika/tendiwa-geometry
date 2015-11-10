package org.tendiwa.geometry.grid.masks

class ArrayGridMask(
    mask: BoundedGridMask
) : BoundedGridMask {
    override val hull = mask.hull

    val bits: Array<BooleanArray> =
        Array(this.hull.width, { BooleanArray(this.hull.height) })

    init {
        hull.forEachTile {
            x, y ->
            if (mask.contains(x, y)) {
                add(x, y)
            }
        }
    }

    private fun add(absX: Int, absY: Int) {
        bits[relativeX(absX)][relativeY(absY)] = true
    }

    override fun contains(x: Int, y: Int): Boolean {
        return if (hull.contains(x, y)) {
            bits[relativeX(x)][relativeY(y)]
        } else {
            false
        }
    }

    private fun relativeX(absoluteX: Int) = absoluteX - hull.x

    private fun relativeY(absoluteY: Int) = absoluteY - hull.y
}
