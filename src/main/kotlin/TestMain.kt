import com.github.IgnacioCarrionN.Tspl
import com.github.IgnacioCarrionN.algorithm.Population
import com.github.IgnacioCarrionN.algorithm.PopulationResult

fun main() {
    val testI = TestInterface()
    testI.runAlgo()
}

class TestInterface : Tspl.OnAlgorithmRunning{

    var genCount = 0

    fun runAlgo(){
        val tspl = Tspl(this)
        when(val answer = tspl.run("/home/casa/IntelliJIDEAProjects/tspl/src/main/resources/cities.json", 5000, doDebug = true)){

            is PopulationResult.Success -> println(answer.pop.getFittest().distance)
            is PopulationResult.Error -> println(answer.message)
        }
    }

    override fun onGenerationEnd(pop: Population) {
        genCount++
        println("Generation: $genCount Distance: ${pop.getFittest().distance}")
    }

}