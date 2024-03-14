package com.example.kotlin_personal_project.viewmodel

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://restcountries.com/v3.1/"


interface CountriesApi {
    @GET("all")
    suspend fun getCountries(): List<Country>

    companion object {
        var CountriesService: CountriesApi? = null
        fun getInstance(): CountriesApi {
            if (CountriesService === null) {
                CountriesService = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                    .create(CountriesApi::class.java)
            }
            return CountriesService!!
        }
    }
}
