package com.parg3v.domain.module

import com.parg3v.domain.repository.ProductsRepository
import com.parg3v.domain.use_cases.ContainsTagUseCase
import com.parg3v.domain.use_cases.DeleteFromFavoritesUseCase
import com.parg3v.domain.use_cases.GetFavoriteProductsCountUseCase
import com.parg3v.domain.use_cases.ProductsListWithFavoritesUseCase
import com.parg3v.domain.use_cases.GetFavoriteProductsUseCase
import com.parg3v.domain.use_cases.GetProductByIdUseCase
import com.parg3v.domain.use_cases.GetProductsUseCase
import com.parg3v.domain.use_cases.SaveToFavoritesUseCase
import com.parg3v.domain.use_cases.SortProductsByPopularityUseCase
import com.parg3v.domain.use_cases.SortProductsByPriceToMaxUseCase
import com.parg3v.domain.use_cases.SortProductsByPriceToMinUseCase
import com.parg3v.domain.use_cases.ValidateNameUseCase
import com.parg3v.domain.use_cases.ValidatePhoneUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductsModule {

    @Provides
    @Singleton
    fun provideGetProductsUseCase(productsRepository: ProductsRepository): GetProductsUseCase {
        return GetProductsUseCase(productsRepository)
    }

    @Provides
    @Singleton
    fun provideGetProductByIdUseCase(productsRepository: ProductsRepository): GetProductByIdUseCase {
        return GetProductByIdUseCase(productsRepository)
    }

    @Provides
    @Singleton
    fun provideValidateNameUseCase(): ValidateNameUseCase {
        return ValidateNameUseCase()
    }

    @Provides
    @Singleton
    fun provideValidatePhoneUseCase(): ValidatePhoneUseCase {
        return ValidatePhoneUseCase()
    }

    @Provides
    @Singleton
    fun provideSortProductsByPopularityUseCase(): SortProductsByPopularityUseCase {
        return SortProductsByPopularityUseCase()
    }

    @Provides
    @Singleton
    fun provideSortProductsByPriceToMaxUseCase(): SortProductsByPriceToMaxUseCase {
        return SortProductsByPriceToMaxUseCase()
    }

    @Provides
    @Singleton
    fun provideSortProductsByPriceToMinUseCase(): SortProductsByPriceToMinUseCase {
        return SortProductsByPriceToMinUseCase()
    }

    @Provides
    @Singleton
    fun provideContainsTagUseCase(): ContainsTagUseCase {
        return ContainsTagUseCase()
    }

    @Provides
    @Singleton
    fun provideGetFavoriteProductsUseCase(productsRepository: ProductsRepository): GetFavoriteProductsUseCase {
        return GetFavoriteProductsUseCase(productsRepository)
    }

    @Provides
    @Singleton
    fun provideSaveToFavoritesUseCase(productsRepository: ProductsRepository): SaveToFavoritesUseCase {
        return SaveToFavoritesUseCase(productsRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteFromFavoritesUseCase(productsRepository: ProductsRepository): DeleteFromFavoritesUseCase {
        return DeleteFromFavoritesUseCase(productsRepository)
    }

    @Provides
    @Singleton
    fun provideProductsListWithFavoritesUseCase(productsRepository: ProductsRepository): ProductsListWithFavoritesUseCase {
        return ProductsListWithFavoritesUseCase(productsRepository)
    }

    @Provides
    @Singleton
    fun provideGetFavoriteProductsCountUseCase(productsRepository: ProductsRepository): GetFavoriteProductsCountUseCase {
        return GetFavoriteProductsCountUseCase(productsRepository)
    }
}