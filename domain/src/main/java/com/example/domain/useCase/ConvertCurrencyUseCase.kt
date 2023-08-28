package com.example.domain.useCase

import com.example.domain.entity.Currency
import com.example.domain.repo.ExchangeRateRepository

class ConvertCurrencyUseCase(private val exchangeRateRepository: ExchangeRateRepository) {

    suspend fun convertCurrency(
        fromCurrency: Currency,
        toCurrency: Currency,
        amount: Double
    ): Result<Any> {
        // Validate inputs
        when {
            amount <= 0 -> return Result.failure(Exception("Invalid input"))
            fromCurrency == toCurrency -> return Result.failure(Exception("Please choose two different currencies"))
        }

        // Fetch conversion rates for Euro (EUR) as base currency
        val baseCurrency = "EUR"
        val conversionRatesResult = exchangeRateRepository.getAllExchangeRates(baseCurrency)

        // Handle repository result
        return when {
            conversionRatesResult.isSuccess -> {
                val conversionRates = conversionRatesResult.getOrNull()!!
                val fromCurrencyToBase = conversionRates.exchangeRates.indexOf(fromCurrency)
                val toCurrencyToBase = conversionRates.exchangeRates.indexOf(toCurrency)
                run {
                    // Calculate conversion using Euro (EUR) as intermediary
                    val convertedAmount = (amount / fromCurrencyToBase) * toCurrencyToBase
                    Result.success(convertedAmount)
                }
            }
            else -> {
                Result.failure(conversionRatesResult.exceptionOrNull()!!)
            }
        }
    }

}
