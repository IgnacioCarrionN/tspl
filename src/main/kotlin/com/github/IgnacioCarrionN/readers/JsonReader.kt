package com.github.IgnacioCarrionN.readers

import com.dslplatform.json.DslJson
import com.github.IgnacioCarrionN.algorithm.City
import com.github.IgnacioCarrionN.algorithm.CityDeserializeResult
import java.io.File
import java.io.FileNotFoundException

internal object JsonReader {

    private val dslJson = DslJson<Any>()

    fun readFile(filePath: String): CityDeserializeResult{
        return try{
            val byteData = File(filePath).readText().toByteArray(Charsets.UTF_8)

            val citiesList = dslJson.deserializeList(City::class.java,byteData,byteData.size)

            if(citiesList == null){
                CityDeserializeResult.Error(message = "Error parsing cities json file")
            }else{
                CityDeserializeResult.Success(citiesList)
            }
        }catch (ex: FileNotFoundException){
            CityDeserializeResult.Error("Json file not found")
        }
    }

}