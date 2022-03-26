package com.example.kaizenplus.model

data class WeatherModel(
    val date: String,
    val astronomy: List<AstronomyModel>,
    val maxtempC: String,
    val maxtempF: String,
    val mintempC: String,
    val mintempF: String,
    val avgtempC: String,
    val avgtempF: String,

    val totalSnow_cm: String,

    val sunHour: String,
    val uvIndex: String,
    val hourly: List<HourlyModel>


)
