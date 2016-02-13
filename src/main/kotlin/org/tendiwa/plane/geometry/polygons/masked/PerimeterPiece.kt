package org.tendiwa.plane.geometry.polygons.masked

import org.tendiwa.math.sliders.CircularMask
import org.tendiwa.math.sliders.CircularSlider
import org.tendiwa.math.sliders.Slider1Sphere
import org.tendiwa.plane.geometry.polygons.Polygon
import org.tendiwa.plane.geometry.polygons.perimeter
import org.tendiwa.tools.argumentConstraint

/**
 * Piece of a perimeter.
 */
data class PerimeterPiece
/**
 * @param center Position of the center.
 * @param cartesianRadius Radius of the piece _in Cartesian coorinates_, not in
 * slider coordinates.
 */
constructor(
    val center: CircularSlider,
    val cartesianRadius: Double
) {
    init {
        argumentConstraint(
            cartesianRadius,
            { it > 0.0 },
            { "radius must be > 0.0" }
        )
    }

    internal fun toSlider1Sphere(perimeter: Double): Slider1Sphere =
        Slider1Sphere(center, Slider1Sphere.Size(cartesianRadius / perimeter))
}

fun Polygon.mask(
    pieces: List<PerimeterPiece>
): MaskedPolygon =
    mask(
        CircularMask(
            piecesToSpheres(pieces)
        )
    )

private fun Polygon.piecesToSpheres(
    pieces: List<PerimeterPiece>
): List<Slider1Sphere> {
    val perimeter = this.perimeter
    return pieces
        .map { scorch -> scorch.toSlider1Sphere(perimeter) }
}
