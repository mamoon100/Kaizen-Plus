package com.example.kaizenplus.model

data class HourlyModel(
    val time: String,
    val tempC: String,
    val tempF: String,
    val windspeedMiles: String,
    val windspeedKmph: String,
    val winddirDegree: String,
    val winddir16Point: String,
    val weatherCode: String,

    val weatherIconUrl: List<ValueModel>,

    val weatherDesc: List<ValueModel>,
    val precipMM: String,
    val precipInches: String,
    val humidity: String,
    val visibility: String,
    val visibilityMiles: String,
    val pressure: String,
    val pressureInches: String,
    val cloudcover: String,

    val HeatIndexC: String,

    val HeatIndexF: String,

    val DewPointC: String,

    val DewPointF: String,

    val WindChillC: String,

    val WindChillF: String,

    val WindGustMiles: String,

    val WindGustKmph: String,

    val FeelsLikeC: String,

    val FeelsLikeF: String,

    val chanceofrain: String,
    val chanceofremdry: String,
    val chanceofwindy: String,
    val chanceofovercast: String,
    val chanceofsunshine: String,
    val chanceoffrost: String,
    val chanceofhightemp: String,
    val chanceoffog: String,
    val chanceofsnow: String,
    val chanceofthunder: String,
    val uvIndex: String


)
