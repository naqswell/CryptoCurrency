package com.example.network_coinstats

import com.example.network_coinstats.CoinsEndpoints.COIN_BY_ID
import com.example.network_coinstats.model.CoinResponse
import com.example.network_coinstats.model.CoinsListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

object CoinsEndpoints {
    const val BASE_URL = "https://openapiv1.coinstats.app/"
    const val COINS_PATH = "/coins"

    const val COIN_BY_ID = "coinId"
    const val COIN_BY_ID_PATH = "/coins/{$COIN_BY_ID}"
}

interface CoinStatsApi {

    @GET(CoinsEndpoints.COINS_PATH)
    suspend fun getCoins(
        @Query("page") page: Int,
        @Query("limit") limit: Int = 10,
        @Query("currency") currency: String = "USD",
    ): CoinsListResponse

    @GET(CoinsEndpoints.COIN_BY_ID_PATH)
    suspend fun getCoinById(
        @Path(COIN_BY_ID) id: String,
    ): CoinResponse
}