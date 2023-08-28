package com.example.data.repoImpl

import com.example.data.dataSource.local.HistoryDao
import com.example.data.mapper.HistoryMapper.toDataEntity
import com.example.data.mapper.HistoryMapper.toDomainModelList
import com.example.domain.entity.HistoricalData
import com.example.domain.repo.HistoryRepository

class HistoryRepositoryImpl(private val historyDao: HistoryDao) : HistoryRepository {
    override suspend fun getHistoricalData(base: String, target: String): List<HistoricalData> {
        return historyDao.getHistoricalData(base, target).toDomainModelList()
    }

    override suspend fun insertHistoricalData(history: HistoricalData) {
        historyDao.insertHistoricalData(history.toDataEntity())
    }

}