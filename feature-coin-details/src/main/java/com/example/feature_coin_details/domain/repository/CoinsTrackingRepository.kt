package com.example.feature_coin_details.domain.repository

import com.example.feature_coin_details.domain.model.CoinDetails


interface CoinsTrackingRepository {
    suspend fun upsertCoinTracking(coin: CoinDetails)
    suspend fun removeCoinTracking(coin: CoinDetails)
    suspend fun isCoinTrackingExist(coinId: String): Boolean
}