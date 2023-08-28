package com.example.domain.entity

data class HistoricalData(
    val id: Long,
    val date: String,
    val fromCurrency: String,
    val toCurrency: String,
    val amount: Double,
    val convertedAmount: Double
)

