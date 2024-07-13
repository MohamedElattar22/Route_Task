package com.mobjoy.data.datasourceImpl.providers

import com.mobjoy.data.datasource.ProductsDataSource
import com.mobjoy.data.datasourceImpl.ProductsDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceDependencyProvider {

    @Binds
    abstract fun bindProductsDataSource(
        productsDataSourceImpl: ProductsDataSourceImpl
    ): ProductsDataSource


}