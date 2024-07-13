package com.mobjoy.data.repositoriesImpl.providers

import com.mobjoy.data.repositoriesImpl.ProductsRepositoryImpl
import com.mobjoy.domain.repositories.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryImplProvider {

    @Binds
    abstract fun bindProductsRepository(productsRepositoryImpl: ProductsRepositoryImpl): ProductsRepository

}