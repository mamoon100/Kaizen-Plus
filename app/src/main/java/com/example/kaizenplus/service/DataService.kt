package com.example.kaizenplus.service

import com.example.kaizenplus.BuildConfig
import com.example.kaizenplus.model.SearchResponseModel
import com.example.kaizenplus.model.WeatherDataResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface DataService {
    @GET("weather.ashx")
    suspend fun getWeatherByCity(
        @Query("key") weatherKey: String = BuildConfig.WEATHER_KEY,
        @Query("format") format: String = "json",
        @Query("q") cityName: String
    ): WeatherDataResponseModel

    @GET("search.ashx")
    suspend fun searchByCity(
        @Query("key") weatherKey: String = BuildConfig.WEATHER_KEY,
        @Query("format") format: String = "json",
        @Query("q") cityName: String
    ): SearchResponseModel


}