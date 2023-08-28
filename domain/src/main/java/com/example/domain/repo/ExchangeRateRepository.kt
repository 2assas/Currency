package com.example.domain.repo

import com.example.domain.entity.Currency
import com.example.domain.entity.ExchangeRateEntity

interface ExchangeRateRepository {
    suspend fun getAllExchangeRates(baseCurrency: String): Result<ExchangeRateEntity?>
    suspend fun getSetOfExchangeRates(baseCurrency: String, currencies: String): Result<ExchangeRateEntity?>

}