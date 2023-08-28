package com.example.domain.useCase

import com.example.domain.entity.HistoricalData
import com.example.domain.repo.HistoryRepository
import java.text.SimpleDateFormat
import java.util.*

class HistoricalDataUseCase(private val historyRepository: HistoryRepository) {

    suspend fun insertHistoricalData(history: HistoricalData) {
        historyRepository.insertHistoricalData(history)
    }

    private suspend fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return dateFormat.format(Date())
    }

    private suspend fun calculateThreeDaysAgo(currentDate: String): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val calendar = Calendar.getInstance()
        calendar.time = dateFormat.parse(currentDate) ?: Date()
        calendar.add(Calendar.DAY_OF_YEAR, -3)
        return dateFormat.format(calendar.time)
    }

    private suspend fun getHistoricalDataForLast3Days(): List<HistoricalData> {
        val currentDate = getCurrentDate()
        val threeDaysAgo = calculateThreeDaysAgo(currentDate)
        return historyRepository.getHistoricalDataForDateRange(threeDaysAgo)
    }

    suspend fun getHistoricalDataGroupedByDay(): Map<String, List<HistoricalData>> {
        val historicalData = getHistoricalDataForLast3Days()
        return historicalData.groupBy { it.date }
    }
}