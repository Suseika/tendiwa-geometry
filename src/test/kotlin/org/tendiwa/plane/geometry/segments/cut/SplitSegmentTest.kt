package org.tendiwa.plane.geometry.segments.cut

import org.junit.Test
import org.tendiwa.plane.geometry.segments.ANY
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.segments.slider

class SplitSegmentTest {
    @Test
    fun leftNormalFacesLeft() {
        Segment.ANY
            .run { SplitSegment(this, this.slider(0.4)) }
            .leftNormal()
    }
}
