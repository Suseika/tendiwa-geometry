package org.tendiwa.geometry.shapes

import org.tendiwa.collections.loopedLinks
import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.rectangles.Rectangle
import org.tendiwa.geometry.segments.Segment

interface SegmentGroup {
    val points: Collection<Point>
    val segments: Collection<Segment>
        get() = points.loopedLinks.map { Segment(it.first, it.second) }
    val hull: Rectangle
        get() {
            var minX: Double = Double.POSITIVE_INFINITY
            var minY: Double = Double.POSITIVE_INFINITY
            var maxX: Double = Double.NEGATIVE_INFINITY
            var maxY: Double = Double.NEGATIVE_INFINITY
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
