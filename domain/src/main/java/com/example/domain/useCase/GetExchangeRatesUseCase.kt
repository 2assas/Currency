package com.example.domain.useCase

import com.example.domain.repo.ExchangeRateRepository

class GetExchangeRatesUseCase(private val exchangeRateRepository: ExchangeRateRepository) {
    suspend operator fun invoke() = exchangeRateRepository.getExchangeRates("EUR")
}