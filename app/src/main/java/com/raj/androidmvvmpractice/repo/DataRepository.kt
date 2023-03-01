package com.raj.androidmvvmpractice.repo

import com.raj.androidmvvmpractice.repo.network.PortfolioResponse

interface DataRepository {
    suspend fun getPortfolioData(): Result<PortfolioResponse>
}