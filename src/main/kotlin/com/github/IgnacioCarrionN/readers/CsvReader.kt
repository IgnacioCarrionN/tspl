package com.github.IgnacioCarrionN.readers

import com.github.IgnacioCarrionN.algorithm.City
import com.github.IgnacioCarrionN.algorithm.CityCsvLineResult
import com.github.IgnacioCarrionN.algorithm.CityDeserializeResult
import java.io.File
import java.io.FileNotFoundException

internal object CsvReader {

    fun readFile(filePath: String, separator: Char): CityDeserializeResult {
        val result = mutableListOf<City>()
        val file = File(filePath)

        return try {
            file.forEachLine {
                when(val parseResult = parseLine(it, separator)){
                    is CityCsvLineResult.Success -> result.add(parseResult.city)
                    is CityCsvLineResult.Error -> println(parseResult.message)
                }
            }
            CityDeserializeResult.Success(result)
        }catch (ex: FileNotFoundException){
            CityDeserializeResult.Error("File not found incorrect path")
        }
    }

    private fun parseLine(line: String, separator: Char): CityCsvLineResult {
        val tokens = line.split(separator)
        return if(tokens.isNotEmpty()){
            CityCsvLineResult.Success(City(tokens[0].toInt(), tokens[1].toInt()))
        }else{
            CityCsvLineResult.Error("Failed to parse line")
        }
    }
}