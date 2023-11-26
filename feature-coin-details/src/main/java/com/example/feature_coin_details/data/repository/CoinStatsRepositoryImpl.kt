package com.example.feature_coin_details.data.repository

import com.example.feature_coin_details.data.mapper.toDomainModel
import com.example.feature_coin_details.domain.model.CoinDetails
import com.example.feature_coin_details.domain.repository.CoinsStatsRepository
import com.example.network_coinstats.CoinStatsApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinStatsRepositoryImpl @Inject constructor(
    private val coinStatsApi: CoinStatsApi
): CoinsStatsRepository {
    override fun getCoinById(id: String): Flow<CoinDetails> = flow {
        emit(coinStatsApi.getCoinById(id).toDomainModel())
    }

}