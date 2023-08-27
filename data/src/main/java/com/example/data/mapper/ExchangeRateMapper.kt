package com.example.data.mapper

import com.example.data.dataSource.remote.ExchangeRateResponse
import com.example.domain.entity.Currency
import com.example.domain.entity.ExchangeRateEntity

object ExchangeRateMapper {
    fun map(apiResponse: ExchangeRateResponse): ExchangeRateEntity {
        val currencyList = apiResponse.rates.map { (currencyCode, rate) ->
            Currency(name = currencyCode, value = rate)
        }
        return ExchangeRateEntity(
            timestamp = apiResponse.timestamp,
            baseCurrency = apiResponse.base,
            date = apiResponse.date,
            exchangeRates = currencyList
        )
    }
}