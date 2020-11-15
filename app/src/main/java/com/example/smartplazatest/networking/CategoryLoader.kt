package com.example.smartplazatest.networking

import android.util.Log
import retrofit2.Call
import retrofit2.Response

class CategoryLoader(
        private val onSuccess: (ProductResponse)->Unit,
        private val onError: (Throwable)-> Unit
) {
    fun loadCategory() {
        Api.getApiClient()
                .getAllProducts()
                .enqueue(object : retrofit2.Callback<ProductResponse>{
                    override fun onResponse(
                            call: Call<ProductResponse>,
                            response: Response<ProductResponse>
                    ) {
                        onSuccess(response.body()!!)
                    }
                    override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                        onError(t)
                    }
                })
    }
}