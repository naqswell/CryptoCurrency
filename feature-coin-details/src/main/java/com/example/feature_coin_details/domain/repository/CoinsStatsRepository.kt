package com.example.feature_coin_details.domain.repository

import com.example.feature_coin_details.domain.model.CoinDetails
import kotlinx.coroutines.flow.Flow

interface CoinsStatsRepository {
    fun getCoinById(id: String): Flow<CoinDetails>
}