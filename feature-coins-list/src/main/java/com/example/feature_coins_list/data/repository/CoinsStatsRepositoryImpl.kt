package com.example.feature_coins_list.data.repository

import com.example.feature_coins_list.data.mapper.toDomainModelCoin
import com.example.feature_coins_list.domain.model.Coin
import com.example.feature_coins_list.domain.repository.CoinsStatsRepository
import com.example.network_coinstats.CoinStatsApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinsStatsRepositoryImpl @Inject constructor(
    private val coinStatsApi: CoinStatsApi
): CoinsStatsRepository {

    override fun getCoins(page: Int): Flow<List<Coin>> = flow {
        emit(coinStatsApi.getCoins(page = page).result.toDomainModelCoin())
    }

    override fun getCoinById(id: String): Flow<Coin> = flow {
        emit(coinStatsApi.getCoinById(id = id).toDomainModelCoin())
    }

}