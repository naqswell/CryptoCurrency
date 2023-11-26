package com.example.feature_coins_tracking_list.data.repository

import com.example.cache_coins.dao.CoinsTrackingDao
import com.example.feature_coins_tracking_list.data.mapper.toDomainModel
import com.example.feature_coins_tracking_list.domain.model.CoinTracking
import com.example.feature_coins_tracking_list.domain.repository.CoinsTrackingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CoinsTrackingRepositoryImpl @Inject constructor(
    private val coinsTrackingDao: CoinsTrackingDao,
) : CoinsTrackingRepository {

    override fun getCoinsTracking(): Flow<List<CoinTracking>> =
        coinsTrackingDao
            .getCoinsTrackingList()
            .map { coinTrackingCachedList ->
                coinTrackingCachedList.map { it.toDomainModel() }
            }

}