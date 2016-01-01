package org.tendiwa.plane.geometry.holeygons

import org.tendiwa.plane.geometry.polygons.Polygon

/**
 * Polygon with holes.
 */
data class Holeygon
/**
 * This constructor doesn't validate that [holes] are actually inside the
 * [enclosing] polygon, because it is very expensive to do so. That can be done
 * separately with [Holeygon.validate] method.
 *
 * @param enclosing Polygon that encloses the [holes].
 * @param holes Holes inside the [enclosing] polygon.
 */
(val enclosing: Polygon, val holes: Collection<Polygon>)

