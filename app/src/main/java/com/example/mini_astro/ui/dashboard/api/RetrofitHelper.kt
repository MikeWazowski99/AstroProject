package com.example.mini_astro.ui.dashboard.api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val URL = "https://api.nasa.gov/planetary/"

    private val retrofit =
        Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getInstance(): ApiCalls {
        return retrofit.create(ApiCalls::class.java)
    }
}