package com.github.IgnacioCarrionN

import com.github.IgnacioCarrionN.algorithm.*
import com.github.IgnacioCarrionN.readers.CityFileReader

class Tspl(private val handler: OnAlgorithmRunning? = null) {

    private var doDebug = false

    // Return null if an error occurred reading input data.
    fun run(file: String, generations: Int = 200, populationSize: Int = 50, doDebug: Boolean = false): PopulationResult {
        this.doDebug = doDebug
        val startTime = System.currentTimeMillis()

        return when(val result = CityFileReader.readFile(file)){

            is CityDeserializeResult.Success ->
                PopulationResult.Success(citiesRead(result.cities, populationSize, generations, startTime))
            is CityDeserializeResult.Error -> PopulationResult.Error(result.message)
        }
    }

    private fun citiesRead(cities: List<City>, populationSize: Int, generations: Int, startTime: Long): Population {
        val routeManager = RouteManager()
        routeManager.addCities(cities)

        var pop = Population(populationSize, true, routeManager)
        if(doDebug)
            println("Initial distance: ${pop.getFittest().distance}")

        for(i in 0 until generations) {
            pop = GeneticAlgorithm.evolvePopulation(pop, routeManager)
            handler?.onGenerationEnd(pop)
        }

        val endTime = System.currentTimeMillis()

        if(doDebug){
            println("Finished after $generations generations.")
            println("Final distance: ${pop.getFittest().distance}")
            println("Solution: ")
            println(pop.getFittest())
            println("TIME ELAPSED: ${(endTime - startTime)/ MILLIS_IN_SECOND} seconds.")
        }

        return pop
    }

    interface OnAlgorithmRunning {
        fun onGenerationEnd(pop: Population)
    }

    private companion object {
        const val MILLIS_IN_SECOND = 1000.0
    }
}