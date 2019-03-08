package readers

import algorithm.City
import java.io.File

object CsvReader {

    fun readFile(fileName: String, separator: Char):List<City>{
        val result = mutableListOf<City>()
        val file = File(CsvReader.javaClass.classLoader.getResource(fileName).path)
        println(file.path)
        file.forEachLine {
            val city = parseLine(it, separator)
            result.add(city)
        }

        return result
    }

    private fun parseLine(line: String, separator: Char): City {
        val tokens = line.split(separator)
        return if(tokens.isNotEmpty()){
            City(tokens[0].toInt(), tokens[1].toInt())
        }else{
            println("Failed to parse line")
            return City()
        }
    }
}