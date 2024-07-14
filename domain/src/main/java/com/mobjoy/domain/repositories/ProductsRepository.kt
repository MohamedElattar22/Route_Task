package com.mobjoy.domain.repositories

import com.mobjoy.domain.model.products.ProductsResponse
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getAllProducts(): Flow<ProductsResponse>
}