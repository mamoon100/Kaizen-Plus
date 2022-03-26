package com.example.kaizenplus.repo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.example.kaizenplus.model.SearchApi
import com.example.kaizenplus.model.SearchResponseModel
import com.example.kaizenplus.model.WeatherDataResponseModel

object WeatherRepo {
    val defaultLocationWeather = mutableStateListOf<WeatherDataResponseModel>()
    val searchResults: MutableState<SearchResponseModel?> = mutableStateOf(null)
    private val service = RetroFitBuilder.getInstance()

    suspend fun fetchDefaultWeather(defaultLocationsName: List<String>) {
        defaultLocationWeather.clear()
        for (cityName: String in defaultLocationsName) {
            try {
                val response = fetchWeatherByName(cityName = cityName)
                if (response.data.request == null) throw Exception()
                defaultLocationWeather.add(response)
            } catch (e: Exception) {

            }
        }
    }

    suspend fun fetchWeatherByName(cityName: String): WeatherDataResponseModel {
        return service.getWeatherByCity(cityName = cityName)
    }


    suspend fun fetchSearchResult(keyWord: String) {
        val response = service.searchByCity(cityName = keyWord)
        if (response.search_api != null)
            searchResults.value = response
        else
            searchResults.value = SearchResponseModel(SearchApi(ArrayList()))
    }


}
