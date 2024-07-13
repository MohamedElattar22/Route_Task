package com.mobjoy.domain.model.products

data class ProductsResponse(
	val total: Int? = null,
	val limit: Int? = null,
	val skip: Int? = null,
	val products: List<ProductsItem?>? = null
)
