package com.example.composeproject.data.remote.model

/**
 * Created by OMK on 11/01/23.
 */

data class ProductModel (
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)