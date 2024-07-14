package com.mobjoy.domain.usecases

import com.mobjoy.domain.model.products.ProductsResponse
import com.mobjoy.domain.repositories.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(private val productsRepository: ProductsRepository) {
    suspend fun invoke(): Flow<ProductsResponse> {
        return productsRepository.getAllProducts()
    }
}