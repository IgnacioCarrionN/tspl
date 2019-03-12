import com.github.IgnacioCarrionN.algorithm.City
import com.github.IgnacioCarrionN.algorithm.RouteManager
import io.mockk.mockk
import org.junit.Test

class RouteManagerTest {

    private val city1 = City(1,2)
    private val city2 = City(2,5)

    @Test
    fun addCityAndGetCityTest(){
        val routeManager = RouteManager()
        val city = mockk<City>()

        routeManager.addCity(city)

        assert(routeManager.getCity(0) == city)
    }

    @Test
    fun addCitiesTest(){
        val routeManager = RouteManager()
        val cities = listOf(city1, city2)

        routeManager.addCities(cities)

        assert(routeManager.getCity(0) == city1)
        assert(routeManager.getCity(1) == city2)
    }

    @Test
    fun getNumberOfCitiesTest(){
        val routeManager = RouteManager()
        val cities = listOf(city1,city2)

        routeManager.addCities(cities)

        assert(routeManager.numberOfCities() == 2)
    }
}