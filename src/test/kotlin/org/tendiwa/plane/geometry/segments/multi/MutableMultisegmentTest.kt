package org.tendiwa.plane.geometry.segments.multi

import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.segments.ANY
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.segments.slider
import kotlin.test.assertEquals

class MutableMultisegmentTest {
    @JvmField @Rule val expectRule = ExpectedException.none()

    @Test
    fun splitsMultipleTimes() {
        Segment.ANY
            .run {
                MutableMultisegment(this)
                    .apply {
                        add(slider(0.7))
                        add(slider(0.4))
                        add(slider(0.1))
                    }
            }
            .apply {
                assertEquals(4, subsegments.size)
                assertEquals(3, cuts.size)
            }
    }

    @Test
    fun splitAtEndpoint() {
        expectRule.expect(IllegalArgumentException::class.java)
        expectRule.expectMessage("an endpoint of the segment")
        Segment.ANY
            .run {
                MutableMultisegment(this)
                    .apply { add(start) }
            }
    }

    @Test
    fun splitAtSamePointTwice() {
        expectRule.expect(IllegalArgumentException::class.java)
        expectRule.expectMessage("existing split point")
        Segment.ANY
            .run {
                MutableMultisegment(this)
                    .apply {
                        add(slider(0.2))
                        add(slider(0.2))
                    }
            }
    }

    @Test
    fun splitOutsideOriginalSegmentFails() {
        expectRule.expect(IllegalArgumentException::class.java)
        expectRule.expectMessage("not on the original segment")
        Segment.ANY
            .apply {
                MutableMultisegment(this).add(slider(-1.0))
            }
    }

    @Test
    fun partsAreOrderedFromStartToEnd() {
        Segment(Point(0.0, 0.0), Point(10.0, 0.0))
            .run {
                MutableMultisegment(
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
                println(subsegments)
                assertEquals(subsegments[0].end, subsegments[1].start)
                assertEquals(subsegments[1].end, subsegments[2].start)
                assertEquals(subsegments[2].end, subsegments[3].start)
                assertEquals(subsegments[3].end, subsegments[4].start)
            }
    }
}
