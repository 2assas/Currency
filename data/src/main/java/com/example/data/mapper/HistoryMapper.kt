package com.example.data.mapper

import com.example.data.dataSource.local.HistoricalDataEntity
import com.example.domain.entity.HistoricalData

object HistoryMapper {
    private fun HistoricalDataEntity.toDomainModel(): HistoricalData {
        return HistoricalData(id, date, fromCurrency, toCurrency, amount, convertedAmount)
    }

    fun List<HistoricalDataEntity>.toDomainModelList(): List<HistoricalData> {
        return map { it.toDomainModel() }
    }

    fun HistoricalData.toDataEntity(): HistoricalDataEntity {
        return HistoricalDataEntity(id, date, fromCurrency, toCurrency, amount, convertedAmount)
    }
}