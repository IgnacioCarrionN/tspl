package com.github.IgnacioCarrionN

import com.github.IgnacioCarrionN.algorithm.GeneticAlgorithm
import com.github.IgnacioCarrionN.algorithm.Population
import com.github.IgnacioCarrionN.algorithm.RouteManager
import com.github.IgnacioCarrionN.readers.CsvReader

object Tspl {


    fun run(file: String, generations: Int = 200, populationSize: Int = 50, doDebug: Boolean = false): Population {
        val startTime = System.currentTimeMillis()

        val cities = CsvReader.readFile(file, ',')

        RouteManager.addCities(cities)

        var pop = Population(populationSize, true)
        if(doDebug)
            println("Initial distance: ${pop.getFittest().distance}")

        for(i in 0 until generations) {
            pop = GeneticAlgorithm.evolvePopulation(pop)
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

    const val MILLIS_IN_SECOND = 1000.0

}