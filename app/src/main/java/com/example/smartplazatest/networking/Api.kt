package com.example.smartplazatest.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api  {

    private const val BASE_URL = "https://api.smartplaza.kz/mp/products/products"

    fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}