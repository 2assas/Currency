package com.example.data.dataSource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HistoryDao {
    @Query("SELECT * FROM historical_data WHERE baseCurrency = :base AND targetCurrency = :target ORDER BY id DESC LIMIT 3")
    suspend fun getHistoricalData(base: String, target: String): List<HistoricalDataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistoricalData(history: HistoricalDataEntity)
}