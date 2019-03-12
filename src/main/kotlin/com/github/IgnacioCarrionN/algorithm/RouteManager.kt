package com.github.IgnacioCarrionN.algorithm

class RouteManager {
    private val destinationCities: MutableList<City> = mutableListOf()

    internal fun addCity(city: City){
        destinationCities.add(city)
    }

    internal fun addCities(cities: List<City>){
        destinationCities.addAll(cities)
    }

    internal fun getCity(index: Int): City {
        return destinationCities[index]
    }

    internal fun numberOfCities(): Int {
        return destinationCities.size
    }
}