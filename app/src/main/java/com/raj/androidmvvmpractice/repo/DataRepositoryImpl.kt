package com.raj.androidmvvmpractice.repo

import com.raj.androidmvvmpractice.repo.network.PortfolioResponse
import com.raj.androidmvvmpractice.repo.network.StocksAPI

class DataRepositoryImpl(private val stocksAPI: StocksAPI) : DataRepository {
    override suspend fun getPortfolioData(): Result<PortfolioResponse> {
        return try {
            val response = stocksAPI.getPortfolio()
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}