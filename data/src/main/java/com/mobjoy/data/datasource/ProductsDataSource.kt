package com.mobjoy.data.datasource

import com.mobjoy.domain.model.products.ProductsResponse
import kotlinx.coroutines.flow.Flow

interface ProductsDataSource {
    suspend fun getAllProducts(): Flow<ProductsResponse>
}