package com.example.kaizenplus.model

data class DataModel(
    val request: List<RequestModel>?,
    val current_condition: List<CurrentConditionModel>,
    val weather: List<WeatherModel>,
    val ClimateAverages: List<ClimateAverageModel>
)
