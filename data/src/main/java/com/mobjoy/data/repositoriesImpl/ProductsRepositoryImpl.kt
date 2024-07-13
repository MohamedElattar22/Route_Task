package com.mobjoy.data.repositoriesImpl

import com.mobjoy.data.datasourceImpl.ProductsDataSourceImpl
import com.mobjoy.domain.model.products.ProductsResponse
import com.mobjoy.domain.repositories.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val productsDataSourceImpl: ProductsDataSourceImpl) :
    ProductsRepository {
    override suspend fun getAllProducts(): Flow<ProductsResponse> {
        val res = productsDataSourceImpl.getAllProducts()
        return res
    }
}