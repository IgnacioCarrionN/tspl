package com.github.IgnacioCarrionN.algorithm

import kotlin.random.Random

internal object GeneticAlgorithm {

    const val MUTATION_RATE = 0.015
    const val TOURNAMENT_SIZE = 10
    const val ELITISM = true



    fun evolvePopulation(pop: Population, routeManager: RouteManager): Population{
        val newPopulation = Population(pop.getPopulationSize(), false, routeManager)

        val elitismOffset = if(ELITISM) {
            newPopulation.saveRoute(0, pop.getFittest())
            1
        }else{
            0
        }

        for(i in elitismOffset until newPopulation.getPopulationSize()){

            val parent1 = tournamentSelection(pop, routeManager)
            val parent2 = tournamentSelection(pop, routeManager)

            val child = crossover(parent1, parent2, routeManager)
            newPopulation.saveRoute(i, child)
        }

        for(i in elitismOffset until newPopulation.getPopulationSize()){
            mutate(newPopulation.getRoute(i))
        }


        return newPopulation

    }

    private fun crossover(parent1: Route, parent2: Route, routeManager: RouteManager): Route {
        val child = Route(routeManager)


        val startPos = Random.nextInt(parent1.route.size)
        val endPos = Random.nextInt(parent1.route.size)


        for(i in 0 until child.route.size){
            if(startPos < endPos && i > startPos && i < endPos){
                child.setCity(i, parent1.getCity(i))
            }else if(startPos > endPos) {
                if(i !in (endPos + 1)..(startPos - 1))
                    child.setCity(i, parent1.getCity(i))
            }
        }

        for(i in 0 until parent2.route.size){
            if(!child.containsCity(parent2.getCity(i))){
                for(spare in 0 until child.route.size){
                    if(child.getCity(spare).x == -1){
                        child.setCity(spare, parent2.getCity(i))
                        break
                    }
                }
            }
        }

        return child
    }

    private fun mutate(route: Route) {
        for(routePos1 in 0 until route.route.size){
            if(Random.nextDouble() < MUTATION_RATE){
                val routePos2 = Random.nextInt(route.route.size)

                val city1 = route.getCity(routePos1)
                val citi2 = route.getCity(routePos2)

                route.setCity(routePos2, city1)
                route.setCity(routePos1, citi2)
            }
        }
    }

    private fun tournamentSelection(pop: Population, routeManager: RouteManager): Route {
        val tournamentPop = Population(TOURNAMENT_SIZE, false, routeManager)

        for(i in 0 until TOURNAMENT_SIZE){
            val randomId = Random.nextInt(pop.getPopulationSize())
            tournamentPop.saveRoute(i, pop.getRoute(randomId))
        }

        return tournamentPop.getFittest()
    }

}