import com.github.IgnacioCarrionN.algorithm.City
import org.junit.Test

class CityTest {



    @Test
    fun distanceToMethodTest(){
        val city = City(1,2)
        val other = City(4, 2)

        val distance = city.distanceTo(other)

        assert(distance == 3.0)
    }

}