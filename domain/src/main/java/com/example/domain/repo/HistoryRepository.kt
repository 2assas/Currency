package com.example.domain.repo

import com.example.domain.entity.HistoricalData

interface HistoryRepository {
    suspend fun getHistoricalDataForDateRange(startDate: String): List<HistoricalData>
    suspend fun insertHistoricalData(history: HistoricalData)

}