package com.mobjoy.routetask.products

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobjoy.domain.model.products.ProductsResponse
import com.mobjoy.domain.usecases.GetAllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {

    val productsList = MutableStateFlow(ProductsResponse())
    val isLoading = MutableStateFlow(false)
    val errorMessage = MutableStateFlow("")
    val error = MutableStateFlow(false)
    fun getAllProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            isLoading.emit(true)
            try {
                getAllProductsUseCase.invoke().collect {
                    productsList.emit(it)
                    Log.e("productList", it.toString())
                }
                isLoading.emit(false)
            } catch (e: Exception) {
                isLoading.emit(false)
                error.emit(true)
            } finally {
                isLoading.emit(false)
            }

        }
    }


}