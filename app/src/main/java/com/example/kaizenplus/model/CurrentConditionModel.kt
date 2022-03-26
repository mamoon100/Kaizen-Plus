package com.example.kaizenplus.model

data class CurrentConditionModel(
    val observation_time: String,

    val temp_C: String,

    val temp_F: String,

    val weatherCode: String,

    val weatherIconUrl: List<ValueModel>,

    val weatherDesc: List<ValueModel>,
    val windspeedMiles: String,
    val windspeedKmph: String,
    val winddirDegree: String,
    val winddir16Point: String,
    val precipMM: String,
    val precipInches: String,
    val humidity: String,
    val visibility: String,
    val visibilityMiles: String,
    val pressure: String,
    val pressureInches: String,
    val cloudcover: String,

    val FeelsLikeC: String,

    val FeelsLikeF: String,

    val uvIndex: String


)
