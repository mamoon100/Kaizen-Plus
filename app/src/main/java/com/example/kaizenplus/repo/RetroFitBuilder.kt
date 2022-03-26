package com.example.kaizenplus.repo

import com.example.kaizenplus.BuildConfig
import com.example.kaizenplus.service.DataService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitBuilder {
    fun getInstance(): DataService {
        return Retrofit.Builder().baseUrl(BuildConfig.BaseURL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(DataService::class.java)
    }
}