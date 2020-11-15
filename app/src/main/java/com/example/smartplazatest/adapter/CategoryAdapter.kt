package com.example.smartplazatest.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smartplazatest.R
import com.example.smartplazatest.networking.*
import kotlinx.android.synthetic.main.category_item.view.*
import retrofit2.Call
import retrofit2.Response


class CategoryAdapter(
        private val context:Context,
        private var products: List<SuperCategory?> = mutableListOf(),
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bindMessage(sp: SuperCategory?) {
            view.category_name.text = sp?.name
            view.food_list.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
            Api.getApiClient()
                    .getAllProductsByCategoryId(sp!!.id)
                    .enqueue(object : retrofit2.Callback<ProductResponse>{
                        override fun onResponse(
                                call: Call<ProductResponse>,
                                response: Response<ProductResponse>
                        ) {
                            view.food_list.adapter = FoodAdapter(response.body()!!.productResponses,OnClick = {})
                        }
                        override fun onFailure(call: Call<ProductResponse>, t: Throwable) {

                        }
                    })

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoryViewHolder(
            LayoutInflater.from(parent.context)
                    .inflate(R.layout.category_item,parent,false))


    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: CategoryAdapter.CategoryViewHolder, position: Int) {
        holder.bindMessage(products[position])

    }


}