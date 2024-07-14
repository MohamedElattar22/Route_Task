package com.mobjoy.data.model

import com.google.gson.annotations.SerializedName
import com.mobjoy.domain.model.products.ProductsResponse

data class ProductsResponseDto(

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("limit")
    val limit: Int? = null,

    @field:SerializedName("skip")
    val skip: Int? = null,

    @field:SerializedName("products")
    val products: List<ProductsItemDto?>? = null
) {
    fun toProductResponse(): ProductsResponse {
        return ProductsResponse(
            total = total,
            limit = limit,
            skip = skip,
            products = products?.map {
                it?.toProductItemDto()
            }
        )
    }
}