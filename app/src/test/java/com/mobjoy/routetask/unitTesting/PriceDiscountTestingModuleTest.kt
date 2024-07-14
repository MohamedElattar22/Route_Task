package com.mobjoy.routetask.unitTesting

import org.junit.Assert.assertEquals
import org.junit.Test

class PriceDiscountTestingModuleTest {
    //target - context - expected
    @Test
    fun validatePriceDiscountCalculatorThenReturnTotalPrice() {


        //Arrange
        val actualPrice = 10f
        val discountPercent = 20f
        val actualPriceAfterDiscount = 8.0f
        val priceDiscountModule = PriceDiscountModule()
        //Act
        val result = priceDiscountModule.validatePriceDiscount(
            actualPrice = actualPrice,
            discountPercent = discountPercent
        )

        //Assert
        assertEquals(actualPriceAfterDiscount, result)


    }


}