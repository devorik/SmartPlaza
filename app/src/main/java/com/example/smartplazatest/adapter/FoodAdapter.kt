package com.example.smartplazatest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smartplazatest.R
import com.example.smartplazatest.networking.Product

class FoodAdapter(
    private val products: List<Product?> = listOf(),
    private val OnClick: (Product) -> Unit
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindMessage(product: Product?) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FoodViewHolder(
        LayoutInflater.from(parent.context)
        .inflate(R.layout.food_item,parent,false))


    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: FoodAdapter.FoodViewHolder, position: Int) {
        holder.bindMessage(products[position])
    }
}