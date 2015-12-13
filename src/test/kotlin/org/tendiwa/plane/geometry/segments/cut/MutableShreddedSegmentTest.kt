package org.tendiwa.plane.geometry.segments.cut

import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.segments.ANY
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.segments.slider
import kotlin.test.assertEquals

class MutableShreddedSegmentTest {
    @JvmField @Rule val expectRule = ExpectedException.none()

    @Test
    fun splitsMultipleTimes() {
        Segment.ANY
            .run {
                MutableShreddedSegment(this)
                    .apply {
                        splitAt(slider(0.7))
                        splitAt(slider(0.4))
                        splitAt(slider(0.1))
                    }
            }
            .apply {
                assertEquals(4, parts.size)
                assertEquals(3, cuts.size)
            }
    }

    @Test
    fun splitAtEndpoint() {
        expectRule.expect(IllegalArgumentException::class.java)
        expectRule.expectMessage("an endpoint of the segment")
        Segment.ANY
            .run {
                MutableShreddedSegment(this)
                    .apply { splitAt(start) }
            }
    }

    @Test
    fun splitAtSamePointTwice() {
        expectRule.expect(IllegalArgumentException::class.java)
        expectRule.expectMessage("existing split point")
        Segment.ANY
            .run {
                MutableShreddedSegment(this)
                    .apply {
                        splitAt(slider(0.2))
                        splitAt(slider(0.2))
                    }
            }
    }

    @Test
    fun splitOutsideOriginalSegmentFails() {
        expectRule.expect(IllegalArgumentException::class.java)
        expectRule.expectMessage("not on the original segment")
        Segment.ANY
            .apply {
                MutableShreddedSegment(this).splitAt(slider(-1.0))
            }
    }

    @Test
    fun partsAreOrderedFromStartToEnd() {
        Segment(Point(0.0, 0.0), Point(10.0, 0.0))
            .run {
                MutableShreddedSegment(
                    this,
                    listOf(
                        slider(0.9),
                        slider(0.1),
                        slider(0.4),
                        slider(0.5),
                        slider(0.3)
                    )
                )
            }
            .apply {
                println(parts)
                assertEquals(parts[0].end, parts[1].start)
                assertEquals(parts[1].end, parts[2].start)
                assertEquals(parts[2].end, parts[3].start)
                assertEquals(parts[3].end, parts[4].start)
            }
    }
}
