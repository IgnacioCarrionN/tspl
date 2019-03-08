import algorithm.GeneticAlgorithm
import algorithm.Population
import algorithm.RouteManager
import readers.CsvReader

class Tspl(private val file: String, private val generations: Int = 100, private val populationSize: Int = 50, private val doDebug: Boolean = false) {


    fun evolve(): Population{
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
            println("TIME ELAPSED: ${(endTime - startTime)/MILLIS_IN_SECOND} seconds.")
        }

        return pop
    }


    companion object {
        const val MILLIS_IN_SECOND = 1000.0
    }
}