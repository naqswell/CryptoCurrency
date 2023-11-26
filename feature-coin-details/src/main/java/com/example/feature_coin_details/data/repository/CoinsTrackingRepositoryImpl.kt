package com.example.feature_coin_details.data.repository

import com.example.cache_coins.dao.CoinsTrackingDao
import com.example.feature_coin_details.domain.model.CoinDetails
import com.example.feature_coin_details.data.mapper.toEntityModel
import javax.inject.Inject

class CoinsTrackingRepositoryImpl @Inject constructor(
    private val coinsTrackingDao: CoinsTrackingDao
) : com.example.feature_coin_details.domain.repository.CoinsTrackingRepository {

    override suspend fun upsertCoinTracking(coin: CoinDetails) {
        coinsTrackingDao.upsertFavoriteCoin(coin.toEntityModel())
    }

    override suspend fun removeCoinTracking(coin: CoinDetails) {
        coin.toEntityModel().coinId.let { id -> coinsTrackingDao.deleteCoinTracking(id) }
    }

    override suspend fun isCoinTrackingExist(coinId: String): Boolean {
        return coinsTrackingDao.getCoinTrackingById(coinId) != null
    }
}