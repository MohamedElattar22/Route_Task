package com.mobjoy.routetask.products

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.facebook.shimmer.Shimmer
import com.google.android.material.snackbar.Snackbar
import com.mobjoy.routetask.databinding.ActivityMainBinding
import com.mobjoy.routetask.products.adapters.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ProductsActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var viewModel: ProductsViewModel
    private var productsAdapter = ProductsAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[ProductsViewModel::class.java]
        setContentView(viewBinding.root)
        initViews()

    }

    private fun initViews() {
        utilisingViewModel()
        settingProductsAdapter()

    }

    private fun settingProductsAdapter() {
        viewBinding.productsRV.adapter = productsAdapter
    }

    private fun utilisingViewModel() {
        //binding list from api
        getDataFromViewModel()
        //LoadingContent
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.isLoading.collect {
                if (!it) {
                    hideShimmer()
                } else {
                    showLoadingShimmer()
                }
            }

        }
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.error.collect {
                if (it) {
                    Snackbar.make(
                        this@ProductsActivity,
                        viewBinding.root,
                        "Some thing wint wron",
                        Snackbar.LENGTH_SHORT
                    ).setAction("Rety") {
                        getDataFromViewModel()
                    }
                }
            }
        }

    }

    private fun getDataFromViewModel() {
        viewModel.getAllProducts()
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.productsList.collect {
                Log.e("productList1", it.toString())
                it.products?.let { data ->
                    productsAdapter.bindProductsList(data)
                }
            }
        }
    }

    private fun showLoadingShimmer() {
        val shimmer = Shimmer
            .AlphaHighlightBuilder()
            .setAutoStart(true)
            .setBaseAlpha(0.25f)
            .setHighlightAlpha(0.50f)
            .setDropoff(50f)
            .setDirection(Shimmer.Direction.TOP_TO_BOTTOM)
            .build()

        viewBinding.loadingContent.shimmer.setShimmer(shimmer)
        viewBinding.productsRV.isVisible = false


    }

    private fun hideShimmer() {
        viewBinding.loadingContent.shimmer.stopShimmer()
        viewBinding.loadingContent.shimmer.isVisible = false
        viewBinding.productsRV.isVisible = true
    }
}