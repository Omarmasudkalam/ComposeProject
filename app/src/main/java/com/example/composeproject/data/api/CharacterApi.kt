package com.example.composeproject.data.api

import com.example.composeproject.data.remote.model.CharacterModel
import retrofit2.http.GET

interface CharacterApi {
    @GET(END_POINT)
    suspend fun getCharacter(): List<CharacterModel>

    companion object{
        const val BASE_URL="https://fakestoreapi.com/"
        const val END_POINT="products"
    }
}