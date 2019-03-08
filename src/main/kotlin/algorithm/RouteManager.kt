package algorithm

object RouteManager {
    private val destinationCities: MutableList<City> = mutableListOf()

    fun addCity(city: City){
        destinationCities.add(city)
    }

    fun addCities(cities: List<City>){
        destinationCities.clear()
        destinationCities.addAll(cities)
    }

    fun getCity(index: Int): City {
        return destinationCities[index]
    }

    fun numberOfCities(): Int {
        return destinationCities.size
    }
}