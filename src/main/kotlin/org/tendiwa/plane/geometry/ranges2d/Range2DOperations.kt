package org.tendiwa.plane.geometry.ranges2d

infix fun Range2D.overlaps(other: Range2D) =
    minX < other.maxX && maxX > other.minX && minY < other.maxY && maxY > other.minY;

