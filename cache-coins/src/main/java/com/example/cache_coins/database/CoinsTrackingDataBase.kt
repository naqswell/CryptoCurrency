package com.example.cache_coins.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cache_coins.dao.CoinsTrackingDao
import com.example.cache_coins.model.CoinTrackingCached

private const val DATABASE_VERSION = 1

@Database(
    entities = [CoinTrackingCached::class],
    version = DATABASE_VERSION
)
@TypeConverters(DateTypeConverter::class)
abstract class CoinsTrackingDataBase : RoomDatabase() {
    abstract fun coinsTrackingDao(): CoinsTrackingDao
}