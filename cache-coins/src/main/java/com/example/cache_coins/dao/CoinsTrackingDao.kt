package com.example.cache_coins.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.cache_coins.model.CoinTrackingCached
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinsTrackingDao {

    @Query("SELECT * FROM CoinTrackingCached")
    fun getCoinsTrackingList(): Flow<List<CoinTrackingCached>>

    @Query(
        "SELECT * FROM CoinTrackingCached " +
                "Where coinId = :coinId " +
                "Limit 1"
    )
    suspend fun getCoinTrackingById(coinId: String): CoinTrackingCached?

    @Upsert
    suspend fun upsertFavoriteCoin(coin: CoinTrackingCached)


    @Query("DELETE FROM CoinTrackingCached " +
            "WHERE coinId = :coinId")
    suspend fun deleteCoinTracking(coinId: String)
}