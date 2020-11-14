package com.example.smartplazatest.networking

data class SuperCategory(
    val name:String
)

data class Product(
    val id:Int,
    val name: String,
    val price: Double,
    val superCategory: SuperCategory,
    val photo_1: String
)

data class ProductResponse(val productResponses: List<Product>)