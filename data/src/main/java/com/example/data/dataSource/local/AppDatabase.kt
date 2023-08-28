package com.example.data.dataSource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.entity.HistoricalData

@Database(entities = [HistoricalData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}