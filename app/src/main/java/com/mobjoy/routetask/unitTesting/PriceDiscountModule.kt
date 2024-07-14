package com.mobjoy.routetask.unitTesting

class PriceDiscountModule {
    var actualPrice: Float = 0.0f
    var discountPercent: Float = 0.0f


    fun validatePriceDiscount(
        actualPrice: Float,
        discountPercent: Float,
    ): Float {
        val totalMoneyDiscount = (actualPrice * (discountPercent / 100))
        val totalPriceAfterDiscount = actualPrice - totalMoneyDiscount
        return totalPriceAfterDiscount
    }


}