package com.example.feature_coins_list.domain.repository

import com.example.feature_coins_list.domain.model.Coin
import kotlinx.coroutines.flow.Flow

interface CoinsStatsRepository {
    fun getCoins(page: Int): Flow<List<Coin>>
    fun getCoinById(id: String): Flow<Coin>
}