package com.example.composeproject.repo
import com.example.composeproject.domain.ProductItem

/**
 * Created by OMK on 11/01/23.
 */

interface RepositoryImpl {
    suspend fun  getProduct(): List<ProductItem>
}