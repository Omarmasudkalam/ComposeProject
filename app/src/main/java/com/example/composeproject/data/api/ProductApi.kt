package com.example.composeproject.data.api

import com.example.composeproject.data.remote.model.ProductModel
import retrofit2.http.GET

/**
 * Created by OMK on 11/01/23.
 */

interface ProductApi {
    @GET(END_POINT)
    suspend fun getCharacter(): List<ProductModel>

    companion object{
        const val BASE_URL="https://fakestoreapi.com/"
        const val END_POINT="products"
    }
}