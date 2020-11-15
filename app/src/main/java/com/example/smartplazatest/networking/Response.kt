package com.example.smartplazatest.networking

data class SuperCategory(
        val id: Int,
    val name:String,
//        val product: List<Product>
)

data class Product(
    val name: String,
    val price: Double,
    val superCategory: SuperCategory,
    val photo_1: String
)

data class ProductResponse(val productResponses: List<Product>)