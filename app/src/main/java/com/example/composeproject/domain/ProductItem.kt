package com.example.composeproject.domain

import com.example.composeproject.data.remote.model.ProductModel

/**
 * Created by OMK on 11/01/23.
 */

data class ProductItem (
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)

fun ProductModel.toProductItem() = ProductItem(category, description, id,image,price,title)
