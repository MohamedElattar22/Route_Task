package com.mobjoy.data.model

import com.google.gson.annotations.SerializedName
import com.mobjoy.domain.model.products.ReviewsItem

data class ReviewsItemDto(

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("reviewerName")
    val reviewerName: String? = null,

    @field:SerializedName("reviewerEmail")
    val reviewerEmail: String? = null,

    @field:SerializedName("rating")
    val rating: Int? = null,

    @field:SerializedName("comment")
    val comment: String? = null
) {
    fun toReviewsItem(): ReviewsItem {
        return ReviewsItem(
            date = date,
            reviewerName = reviewerName,
            reviewerEmail = reviewerEmail,
            rating = rating,
            comment = comment
        )
    }
}