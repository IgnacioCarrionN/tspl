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

    @Test
    fun toStringTest(){
        val city = City(3, 15)

        val cityString = "(3, 15)"

        assert(city.toString() == cityString)
    }

}