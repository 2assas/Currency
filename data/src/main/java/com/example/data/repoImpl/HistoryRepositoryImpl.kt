package com.example.data.repoImpl

import com.example.data.dataSource.local.HistoryDao
import com.example.data.mapper.HistoryMapper.toDataEntity
import com.example.data.mapper.HistoryMapper.toDomainModelList
import com.example.domain.entity.HistoricalData
import com.example.domain.repo.HistoryRepository
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor (private val historyDao: HistoryDao) : HistoryRepository {
    override suspend fun getHistoricalDataForDateRange(startDate: String): List<HistoricalData> {
        return historyDao.getHistoricalDataForDateRange(startDate).toDomainModelList()
    }

    override suspend fun insertHistoricalData(history: HistoricalData) {
        historyDao.insertHistoricalData(history.toDataEntity())
    }

}