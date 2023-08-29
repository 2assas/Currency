package com.example.data.dataSource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HistoryDao {
    @Query("SELECT * FROM historical_data WHERE date >= :startDate ORDER BY date DESC")
    fun getHistoricalDataForDateRange(startDate: String): List<HistoricalDataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHistoricalData(history: HistoricalDataEntity)
}