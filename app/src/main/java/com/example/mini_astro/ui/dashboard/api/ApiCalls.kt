package com.example.mini_astro.ui.dashboard.api
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiCalls {
        @GET("apod?")
        suspend fun getNasaData(@Query("api_key") key: String, @Query("date") date: String): Response<NasaResponse>

    data class NasaResponse(
        @SerializedName("date") val date: String,
        @SerializedName("title") val title: String,
        @SerializedName("explanation") val expedition: String,
        @SerializedName("url") val url: String,
    )
}