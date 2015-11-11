package org.tendiwa.geometry.grid.tiles

import org.tendiwa.geometry.grid.constructors.centeredGridRectangle
import org.tendiwa.geometry.grid.dimensions.by
import org.tendiwa.geometry.grid.masks.FiniteGridMask
import org.tendiwa.geometry.grid.masks.borders.border
import org.tendiwa.geometry.grid.metrics.GridMetric

fun Tile.neighbors(metric: GridMetric = GridMetric.KING): FiniteGridMask =
    when (metric) {
        GridMetric.KING -> centeredGridRectangle(this, 3 by 3).border
        else -> throw UnsupportedOperationException()
    }
