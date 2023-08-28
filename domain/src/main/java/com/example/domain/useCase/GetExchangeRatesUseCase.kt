package com.example.domain.useCase

import com.example.domain.repo.ExchangeRateRepository

class GetExchangeRatesUseCase(private val exchangeRateRepository: ExchangeRateRepository) {
    suspend fun getAllExchangeRates() = exchangeRateRepository.getAllExchangeRates("EUR")
    suspend fun getSetOfExchangeRates() = exchangeRateRepository.getSetOfExchangeRates("EUR","EGP,SAR,AED,USD,KWD,GBP,CNY,SEK,CHF,JPY" )
}