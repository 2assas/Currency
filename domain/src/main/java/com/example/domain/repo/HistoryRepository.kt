package com.example.domain.repo

import com.example.domain.entity.HistoricalData

interface HistoryRepository {
    suspend fun getHistoricalData(base: String, target: String): List<HistoricalData>
    suspend fun insertHistoricalData(history: HistoricalData)

}