package com.github.IgnacioCarrionN.algorithm

import java.lang.Exception

internal sealed class CityDeserializeResult {
    data class Success(val cities: List<City>) : CityDeserializeResult()
    data class Error(val message: String, val cause: Exception? = null) : CityDeserializeResult()
}