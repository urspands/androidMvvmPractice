package com.raj.androidmvvmpractice.repo.network

import retrofit2.http.GET

interface StocksAPI {
    companion object {
        const val BASE_URL = "https://storage.googleapis.com/cash-homework/cash-stocks-api/"
        private const val PORTFOLIO = "portfolio.json"
        private const val PORTFOLIO_MALFORMED = "portfolio_malformed.json"
        private const val PORTFOLIO_EMPTY_RESPONSE = "portfolio_empty.json"
    }

    @GET(PORTFOLIO)
    suspend fun getPortfolio(): PortfolioResponse
}