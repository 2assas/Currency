package com.example.data.dataSource.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historical_data")
data class HistoricalDataEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val date: String,
    val fromCurrency: String,
    val toCurrency: String,
    val amount: Double,
    val convertedAmount: Double
)