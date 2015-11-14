package org.tendiwa.geometry.grid.segments.ortho

import org.tendiwa.geometry.grid.segments.GridSegment

interface OrthoGridSegment : GridSegment {
    val endX: Int
    val endY: Int
}
