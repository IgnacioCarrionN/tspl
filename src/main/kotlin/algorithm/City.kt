package algorithm

import kotlin.math.pow
import kotlin.random.Random


/**
 * City.kt
 * Models a city
 * Gets 2 values as coordinates. If no values are given, it generates 2 random coordinates.
 */
class City(val x: Int = Random.nextInt(MAX_X_COORDINATE), val y: Int = Random.nextInt(MAX_Y_COORDINATE)){



    fun distanceTo(city: City): Double {
        val xDistance = Math.abs(x - city.x.toDouble())
        val yDistance = Math.abs(y - city.y.toDouble())
        return Math.sqrt(xDistance.pow(2) + yDistance.pow(2))
    }

    override fun toString(): String {
        return "($x, $y)"
    }


    companion object {
        // Constants for map max size.
        const val MAX_X_COORDINATE = 200
        const val MAX_Y_COORDINATE = 200
    }
}