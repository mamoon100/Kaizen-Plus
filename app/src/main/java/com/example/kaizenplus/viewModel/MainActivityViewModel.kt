package com.example.kaizenplus.viewModel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kaizenplus.R
import com.example.kaizenplus.model.SearchResponseModel
import com.example.kaizenplus.model.WeatherDataResponseModel
import com.example.kaizenplus.repo.WeatherRepo
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val weatherRepo = WeatherRepo
    private var job = Job()
        get() {
            if (field.isCancelled) field = Job()
            return field
        }

    init {
        viewModelScope.launch {
            weatherRepo.fetchDefaultWeather(
                application.resources.getStringArray(R.array.default_city_name)
                    .toList()
            )
        }
    }


    fun fetchResults(searchWord: String) {
        job.cancel()
        viewModelScope.launch(job) {
            delay(300)
            weatherRepo.fetchSearchResult(searchWord)
        }
    }


    suspend fun fetchCityWeather(cityName: String): WeatherDataResponseModel {
        return weatherRepo.fetchWeatherByName(cityName = cityName)
    }

    fun getWeather(): SnapshotStateList<WeatherDataResponseModel> {
        return weatherRepo.defaultLocationWeather
    }

    fun getSearchResults(): MutableState<SearchResponseModel?> {
        return weatherRepo.searchResults
    }

}