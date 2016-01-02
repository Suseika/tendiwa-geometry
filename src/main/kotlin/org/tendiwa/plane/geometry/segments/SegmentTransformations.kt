package org.tendiwa.plane.geometry.segments

import org.tendiwa.plane.geometry.ranges2d.Range2D

fun Segment.toRange(): Range2D =
    object : Range2D {
        override val minX: Double = Math.min(start.x, end.x)
        override val minY: Double = Math.min(start.y, end.y)
        override val maxX: Double = Math.max(start.x, end.x)
        override val maxY: Double = Math.max(start.y, end.y)
    }
