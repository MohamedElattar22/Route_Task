package com.mobjoy.data.datasourceImpl

import com.mobjoy.data.api.WebServices
import com.mobjoy.data.datasource.ProductsDataSource
import com.mobjoy.domain.model.products.ProductsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsDataSourceImpl @Inject constructor(private val webServices: WebServices) :
    ProductsDataSource {
    override suspend fun getAllProducts(): Flow<ProductsResponse> = flow {
        val result = webServices.getAllProducts()
        emit(result.toProductResponse())
    }
}
