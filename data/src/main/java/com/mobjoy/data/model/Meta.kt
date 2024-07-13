package com.mobjoy.data.model

import com.google.gson.annotations.SerializedName
import com.mobjoy.domain.model.Meta

data class Meta(

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("qrCode")
    val qrCode: String? = null,

    @field:SerializedName("barcode")
    val barcode: String? = null,

    @field:SerializedName("updatedAt")
    val updatedAt: String? = null
) {
    fun toMeta(): Meta {
        return Meta(
            createdAt = createdAt,
            qrCode = qrCode,
            barcode = barcode,
            updatedAt = updatedAt
        )
    }
}