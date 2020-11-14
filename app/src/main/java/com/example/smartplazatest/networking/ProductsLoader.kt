package com.example.smartplazatest.networking

import android.util.Log
import retrofit2.Call
import retrofit2.Response

class ProductsLoader(
    private val onSuccess: (ProductResponse)->Unit,
    private val onError: (Throwable)-> Unit
) {
    fun loadProducts() {
        Api.getApiClient()
            .getAllProducts()
            .enqueue(object : retrofit2.Callback<ProductResponse>{
                override fun onResponse(
                    call: Call<ProductResponse>,
                    response: Response<ProductResponse>
                ) {
                    onSuccess(response.body()!!)
                   // val productResponse = response.body()
                    Log.d("taaaag", response.body().toString())
                }
                override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                    onError(t)
                    Log.d("err",t.message)
                }
            })
    }
}