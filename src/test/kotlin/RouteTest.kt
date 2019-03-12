import com.github.IgnacioCarrionN.algorithm.City
import com.github.IgnacioCarrionN.algorithm.Route
import com.github.IgnacioCarrionN.algorithm.RouteManager
import io.mockk.*
import org.junit.Before
import org.junit.Test

class RouteTest {

    private val routeManager = spyk<RouteManager>()

    private val city1 = City(1,0)
    private val city2 = City(4, 0)
    private val city3 = City(16, 0)

    @Before
    fun setup() {
        every { routeManager.numberOfCities() } returns 3
        for(i in 0 until routeManager.numberOfCities()){
            routeManager.addCity(City())
        }
    }

    @Test
    fun getCityReturnsCityOnList(){
        val route = Route(routeManager)
        route.setCity(0, city1)

        assert(route.getCity(0) == city1)
    }

    @Test
    fun setCitySaveCityOnList(){
        val city = mockk<City>()
        val route = Route(routeManager)

        route.setCity(2,city)

        assert(route.route[2] == city)
    }

    @Test
    fun getDistanceTest(){
        val route = Route(routeManager)
        route.setCity(0,city1)
        route.setCity(1, city2)
        route.setCity(2, city3)

        val distance = 3 + 12 + 15

        assert(route.distance == distance)
    }

    @Test
    fun getFitnessTest(){
        val route = Route(routeManager)
        route.setCity(0,city1)
        route.setCity(1, city2)
        route.setCity(2, city3)

        val fitness = 1.0/(3 + 12 + 15 )

        assert(route.fitness == fitness)
    }

    @Test
    fun containsCityTest(){
        val route = Route(routeManager)
        route.setCity(0, city1)

        assert(route.containsCity(city1))
        assert(!route.containsCity(city2))
    }

    @Test
    fun toStringTest(){
        val route = Route(routeManager)
        route.setCity(0,city1)
        route.setCity(1,city2)
        route.setCity(2, city3)

        val routeString = "(1, 0)|(4, 0)|(16, 0)|"

        assert(routeString == route.toString())
    }

    // TODO Test generateIndividual method
    @Test
    fun generateIndividualTest(){
        routeManager.addCity(city1)
        routeManager.addCity(city2)
        routeManager.addCity(city3)

        val route = mockk<Route>()

        assert(true)
    }
}