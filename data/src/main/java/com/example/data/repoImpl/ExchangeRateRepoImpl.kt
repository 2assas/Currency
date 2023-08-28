package com.example.data.repoImpl

import com.example.data.BuildConfig
import com.example.data.dataSource.remote.ApiService
import com.example.data.mapper.ExchangeRateMapper
import com.example.domain.entity.ExchangeRateEntity
import com.example.domain.repo.ExchangeRateRepository

class ExchangeRateRepoImpl(private val apiService: ApiService) : ExchangeRateRepository {
    override suspend fun getExchangeRates(baseCurrency: String): Result<ExchangeRateEntity?> {
        return try {
            val response = apiService.getLatestExchangeRates(BuildConfig.FIXER_API_ACCESS_KEY, "EUR") // EUR as base currency
            if (response.isSuccessful) {
                val conversionRates = response.body()?.let { ExchangeRateMapper.map(it) }
                Result.success(conversionRates)
            } else {
                Result.failure(Error("API response indicates failure"))
            }
        } catch (e: Exception) {
            Result.failure(Exception("Error fetching exchange rates: ${e.message}", e))
        }
    }
}