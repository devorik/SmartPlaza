package com.example.smartplazatest.networking

import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("products")
    fun getAllProducts() : Call<ProductResponse>
}