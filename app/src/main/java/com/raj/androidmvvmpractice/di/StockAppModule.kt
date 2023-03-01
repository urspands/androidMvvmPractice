package com.raj.androidmvvmpractice.di

import com.raj.androidmvvmpractice.repo.DataRepository
import com.raj.androidmvvmpractice.repo.DataRepositoryImpl
import com.raj.androidmvvmpractice.repo.network.StocksAPI
import com.raj.androidmvvmpractice.repo.network.StocksAPI.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StockAppModule {
    @Provides
    @Singleton
    fun provideDataRepository(stocksAPI: StocksAPI):DataRepository = DataRepositoryImpl(stocksAPI)

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideStockAPI(retrofit: Retrofit): StocksAPI = retrofit.create(StocksAPI::class.java)
}