package org.tendiwa.geometry.grid.masks.mutable

interface MutableGridMask {
    fun add(x: Int, y: Int)

    fun remove(x: Int, y: Int)
}
