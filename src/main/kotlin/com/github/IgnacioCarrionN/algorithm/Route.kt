package com.github.IgnacioCarrionN.algorithm

class Route(private val routeManager: RouteManager) {

    val route: MutableList<City> = MutableList(routeManager.numberOfCities()){City(-1,-1)}

    internal var fitness: Double = 0.0
        get() {
            if(field == 0.0){
                fitness = 1/distance.toDouble()
            }
            return field
        }
    var distance: Int = 0
        get() {
            if(field == 0){
                var routeDistance = 0.0
                for(i in 0 until route.size){
                    val fromCity = getCity(i)
                    val toCity = if(i +1 < route.size) getCity(i+1) else getCity(0)

                    routeDistance += fromCity.distanceTo(toCity)
                }
                distance = routeDistance.toInt()
            }
            return field
        }

    internal fun generateIndividual(){
        for(i in 0 until routeManager.numberOfCities()){
            setCity(i, routeManager.getCity(i))
        }
        route.shuffle()
    }

    fun getCity(routePosition: Int): City{
        return route[routePosition]
    }

    internal fun setCity(routePosition: Int, city: City) {
        route[routePosition] = city
        fitness = 0.0
        distance = 0
    }

    fun containsCity(city: City): Boolean {
        return route.contains(city)
    }

    override fun toString(): String {
        val builder = StringBuilder()
        for(i in 0 until route.size)
            builder.append("${getCity(i)}|")
        return builder.toString()
    }
}