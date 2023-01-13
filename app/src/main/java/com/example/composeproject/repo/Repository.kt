package com.example.composeproject.repo

/**
 * Created by OMK on 11/01/23.
 */

import com.example.composeproject.data.api.ProductApi
import com.example.composeproject.domain.toProductItem
import javax.inject.Inject

class Repository @Inject constructor(
    private val productApi: ProductApi,
): RepositoryImpl {
    override suspend fun getProduct()= productApi.getCharacter().map { it.toProductItem() }
}