package com.github.IgnacioCarrionN.algorithm

import java.lang.Exception

internal sealed class CityCsvLineResult {
    data class Success(val city: City) : CityCsvLineResult()
    data class Error(val message: String, val ex: Exception? = null) : CityCsvLineResult()
}