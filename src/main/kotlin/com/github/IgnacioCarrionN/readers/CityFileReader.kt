package com.github.IgnacioCarrionN.readers

import com.github.IgnacioCarrionN.algorithm.CityDeserializeResult

internal object CityFileReader {
    fun readFile(filePath: String): CityDeserializeResult {
        return when {
            filePath.endsWith(".csv") -> CsvReader.readFile(filePath, ',')
            filePath.endsWith(".json") -> JsonReader.readFile(filePath)
            else -> CityDeserializeResult.Error("File extension not supported")
        }
    }
}