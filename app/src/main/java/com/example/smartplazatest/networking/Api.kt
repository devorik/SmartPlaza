package com.example.smartplazatest.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api  {

    private const val BASE_URL = "https://api.smartplaza.kz/mp/products/"
    //private const val BASE_URL = "https://api.smartplaza.kz/mp/products/products?highCost=2000&sortName=costAscend&lowCost=100&pageSize=20&pageNumber=1/"

    fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getApiClient() =
        getRetrofit().create(ApiClient::class.java)
}