package com.example.currencyconverter.di

import com.example.data.dataSource.local.HistoryDao
import com.example.data.dataSource.remote.ApiService
import com.example.data.repoImpl.ExchangeRateRepoImpl
import com.example.data.repoImpl.HistoryRepositoryImpl
import com.example.domain.repo.ExchangeRateRepository
import com.example.domain.repo.HistoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideExchangeRateRepository(apiService: ApiService): ExchangeRateRepository {
        return ExchangeRateRepoImpl(apiService)
    }

    @Provides
    fun provideHistoryRepository(historyDao: HistoryDao): HistoryRepository {
        return HistoryRepositoryImpl(historyDao)
    }
}