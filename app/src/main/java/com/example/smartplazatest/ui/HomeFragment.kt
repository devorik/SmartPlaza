package com.example.smartplazatest.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smartplazatest.R
import com.example.smartplazatest.networking.Api
import com.example.smartplazatest.networking.ApiClient
import com.example.smartplazatest.networking.ProductResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onResume() {
        super.onResume()

        Api.getApiClient()
            .getAllProducts()
            .enqueue(object : retrofit2.Callback<ProductResponse>{
                override fun onResponse(
                    call: Call<ProductResponse>,
                    response: Response<ProductResponse>
                ) {
                    val productResponse = response.body()
                    Log.d("taaaag", productResponse.toString())
                }

                override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                    Log.d("err",t.message)
                }


            })
    }


}