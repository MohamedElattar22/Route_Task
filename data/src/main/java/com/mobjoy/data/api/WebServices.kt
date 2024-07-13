package com.mobjoy.data.api

import com.mobjoy.data.model.ProductsResponseDto
import retrofit2.http.GET


interface WebServices {
    @GET("products")
    suspend fun getAllProducts(): ProductsResponseDto
}
