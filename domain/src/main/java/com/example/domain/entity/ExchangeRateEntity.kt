package com.example.domain.entity

data class ExchangeRateEntity(
    val timestamp: Long,
    val baseCurrency: String,
    val date: String,
    val exchangeRates: List<Currency>
)
data class Currency(
    val name: String,
    val value: Double
)