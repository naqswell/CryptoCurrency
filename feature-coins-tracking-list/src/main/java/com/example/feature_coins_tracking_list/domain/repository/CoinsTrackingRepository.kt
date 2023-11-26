package com.example.feature_coins_tracking_list.domain.repository

import com.example.feature_coins_tracking_list.domain.model.CoinTracking
import kotlinx.coroutines.flow.Flow

interface CoinsTrackingRepository {
    fun getCoinsTracking(): Flow<List<CoinTracking>>
}