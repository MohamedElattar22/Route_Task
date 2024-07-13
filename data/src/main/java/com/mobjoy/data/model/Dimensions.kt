package com.mobjoy.data.model

import com.google.gson.annotations.SerializedName
import com.mobjoy.domain.model.products.Dimensions

data class Dimensions(

    @field:SerializedName("depth")
    val depth: Any? = null,

    @field:SerializedName("width")
    val width: Any? = null,

    @field:SerializedName("height")
    val height: Any? = null
) {
    fun toDimensions(): Dimensions {
        return Dimensions(
            depth = depth,
            width = width,
            height = height
        )
    }
}