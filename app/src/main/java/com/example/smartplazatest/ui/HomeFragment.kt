package com.example.smartplazatest.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartplazatest.R
import com.example.smartplazatest.adapter.FoodAdapter
import com.example.smartplazatest.networking.Api
import com.example.smartplazatest.networking.ApiClient
import com.example.smartplazatest.networking.ProductResponse
import com.example.smartplazatest.networking.ProductsLoader
import kotlinx.android.synthetic.main.fragment_home.*
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

        food_list.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,true)

        ProductsLoader(
            onSuccess = {
                food_list.adapter = FoodAdapter(it.productResponses,OnClick = {

                })
            },
            onError = {
                Log.d("Taaag",it.message)
            }
        ).loadProducts()
    }


}