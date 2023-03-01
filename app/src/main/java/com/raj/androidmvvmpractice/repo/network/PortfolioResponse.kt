package com.raj.androidmvvmpractice.repo.network

data class PortfolioResponse(val stocks: List<Stock>)


data class Stock(val currency: String, val name: String)