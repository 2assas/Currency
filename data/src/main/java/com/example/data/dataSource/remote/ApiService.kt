package com.example.data.dataSource.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("latest")
    suspend fun getLatestExchangeRates(
        @Query("access_key") accessKey: String,
        @Query("base") base: String,
    ): Response<ExchangeRateResponse>


    @GET("latest")
    suspend fun getExchangeRatesForCurrenciesList(
        @Query("access_key") accessKey: String,
        @Query("base") baseCurrency: String,
        @Query("symbols") symbols: String
    ): Response<ExchangeRateResponse>


}