package com.github.IgnacioCarrionN.algorithm

sealed class PopulationResult {
    data class Success(val pop: Population) : PopulationResult()
    data class Error(val message: String, val ex: Exception? = null) : PopulationResult()
}