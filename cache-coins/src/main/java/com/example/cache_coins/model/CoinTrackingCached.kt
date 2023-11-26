package com.example.cache_coins.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.cache_coins.database.DateTypeConverter
import java.util.Date

@Entity
data class CoinTrackingCached(
    @[PrimaryKey ColumnInfo(name = "coinId")] val coinId: String,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "symbol") val symbol: String?,
    @ColumnInfo(name = "icon") val icon: String?,
    @ColumnInfo(name = "price") val price: Double?,
    @ColumnInfo(name = "rank") val rank: Int,
    @ColumnInfo(name = "priceChanged1d") val priceChanged1d: Double?,
    @ColumnInfo(name = "priceChanged1h") val priceChanged1h: Double?,
    @ColumnInfo(name = "priceChanged1w") val priceChanged1w: Double?,

    @[ColumnInfo(name = "LastUpdated") TypeConverters(DateTypeConverter::class)]
    val lastUpdated: Date?

)