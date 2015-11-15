package org.tendiwa.geometry.continuum.shapes

import org.tendiwa.geometry.continuum.points.Point
import org.tendiwa.geometry.continuum.rectangles.Rectangle

interface Shape {
    val points: List<Point>
    val hull: Rectangle
        get() {
            var minX: Double = Double.MAX_VALUE
            var minY: Double = Double.MAX_VALUE
            var maxX: Double = Double.MIN_VALUE
            var maxY: Double = Double.MIN_VALUE
            for (point in this.points) {
                if (minX > point.x) {
                    minX = point.x
                }
                if (minY > point.y) {
                    minY = point.y
                }
                if (maxX < point.x) {
                    maxX = point.x
                }
                if (maxY < point.y) {
                    maxY = point.y
                }
            }
            return Rectangle(
                minX,
                minY,
                maxX - minX,
                maxY - minY
            );
        }
}
