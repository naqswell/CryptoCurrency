package com.example.feature_coins_tracking_list.domain.model

import java.util.Date

data class CoinTracking(
    val coinId: String,
    val name: String?,
    val symbol: String?,
    val icon: String?,
    val price: Double?,
    val rank: Int,
    val priceChanged1d: Double?,
    val priceChanged1h: Double?,
    val priceChanged1w: Double?,
    val lastUpdated: Date?
)