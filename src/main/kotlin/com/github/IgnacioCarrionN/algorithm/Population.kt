package com.github.IgnacioCarrionN.algorithm

class Population(populationSize: Int, initialize: Boolean, routeManager: RouteManager) {
    private val routes: Array<Route> = Array(populationSize) {Route(routeManager)}

    init {
        if(initialize){
            for(i in 0 until populationSize){
                val newRoute = Route(routeManager)
                newRoute.generateIndividual()
                routes[i] = newRoute
            }
        }
    }

    fun getRoute(index: Int): Route{
        return routes[index]
    }

    fun getFittest(): Route{
        var fittest = routes[0]
        for(i in 0 until routes.size){
            if(fittest.fitness <= getRoute(i).fitness){
                fittest = getRoute(i)
            }
        }
        return fittest
    }

    internal fun getPopulationSize() = routes.size
    internal fun saveRoute(index: Int, route: Route) {
        routes[index] = route
    }
}