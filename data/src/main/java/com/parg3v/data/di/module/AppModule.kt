package com.parg3v.data.di.module

import android.content.Context
import androidx.room.Room
import com.parg3v.data.config.NetworkConfig
import com.parg3v.data.local.database.ProductsDatabase
import com.parg3v.data.remote.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyApi(): Api {
        return Retrofit.Builder()
            .baseUrl(NetworkConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Singleton
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        ProductsDatabase::class.java,
        "room"
    ).build()

    @Singleton
    @Provides
    fun provideYourDao(db: ProductsDatabase) = db.productsDao
}