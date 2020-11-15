package com.example.smartplazatest.networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("products")
    fun getAllProducts() : Call<ProductResponse>

    @GET("products")
    fun getAllProductsByCategoryId(@Query("superCategoryId") id:Int) : Call<ProductResponse>
}