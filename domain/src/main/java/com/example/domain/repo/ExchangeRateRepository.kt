package com.example.domain.repo

import com.example.domain.entity.Currency
import com.example.domain.entity.ExchangeRateEntity

interface ExchangeRateRepository {

    suspend fun getExchangeRates(baseCurrency: String): Result<ExchangeRateEntity?>

}