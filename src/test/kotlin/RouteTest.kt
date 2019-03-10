import com.github.IgnacioCarrionN.algorithm.City
import com.github.IgnacioCarrionN.algorithm.Route
import com.github.IgnacioCarrionN.algorithm.RouteManager
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import org.junit.Before
import org.junit.Test

class RouteTest {

    val routeManager = spyk<RouteManager>()


    @Before
    fun setup() {
        every { routeManager.numberOfCities() } returns 20
    }


    @Test
    fun setCitySaveCityOnList(){
        val city = mockk<City>()
        val route = Route(routeManager)

        route.setCity(3,city)

        assert(route.getCity(3) == city)
    }
}