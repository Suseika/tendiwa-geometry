package org.tendiwa.plane.geometry.shapes

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.rectangles.Rectangle
import org.tendiwa.plane.geometry.segments.Segment

interface SegmentGroup {
    val points: Collection<Point>
    val segments: Collection<Segment>
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

fun SegmentGroup(vararg segmentGroups: SegmentGroup): SegmentGroup =
    object : SegmentGroup {
        override val segments: Collection<Segment>
            get() = segmentGroups.flatMap { it.segments }

        override val points: Collection<Point>
            get() = segmentGroups
                .flatMap { it.points }
                .distinct()
    }
