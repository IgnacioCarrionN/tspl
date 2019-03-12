package com.github.IgnacioCarrionN.algorithm

import com.dslplatform.json.*
import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.random.Random


/**
 * City.kt
 * Models a city
 * Gets 2 values as coordinates. If no values are given, it generates 2 random coordinates.
 */
@CompiledJson(onUnknown = CompiledJson.Behavior.IGNORE)
class City(
    @JsonAttribute(nullable = false)
    val x: Int = Random.nextInt(MAX_X_COORDINATE),
    @JsonAttribute(nullable = false)
    val y: Int = Random.nextInt(MAX_Y_COORDINATE)) : JsonObject {
    override fun serialize(writer: JsonWriter, minimal: Boolean) {
        // Not implementation needed
    }


    fun distanceTo(city: City): Double {
        val xDistance = (x - city.x.toDouble()).absoluteValue
        val yDistance = (y - city.y.toDouble()).absoluteValue
        return Math.sqrt(xDistance.pow(2) + yDistance.pow(2))
    }

    override fun toString(): String {
        return "($x, $y)"
    }


    companion object {
        // Constants for map max size.
        const val MAX_X_COORDINATE = 200
        const val MAX_Y_COORDINATE = 200
        val JSON_READER = JsonReader.ReadJsonObject {
            it.fillName()
            it.nextToken
            val x = NumberConverter.deserializeInt(it)
            it.nextToken
            it.nextToken
            it.fillName()
            it.nextToken
            val y = NumberConverter.deserializeInt(it)
            it.nextToken
             City(x,y)
        }
    }
}