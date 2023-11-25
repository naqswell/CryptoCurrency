package com.example.network_coinstats.di

import com.example.network_coinstats.CoinStatsApi
import com.example.network_coinstats.CoinStatsApiKeyInterceptor
import com.example.network_coinstats.CoinsEndpoints
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object CoinsStatsModule {

    val coinStatsApiToken = "dZas2h3a8lAVXu4x57rUTlUDOFC4paFWFFWfOto/fXQ="

    @[Provides Singleton]
    fun provideCoinsRetrofitClient(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        val json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
        val contentType = "application/json".toMediaType()

        val client = okHttpClient
            .newBuilder()
            .addInterceptor(
                CoinStatsApiKeyInterceptor(coinStatsApiToken)
            ).build()

        return Retrofit
            .Builder()
            .addConverterFactory(json.asConverterFactory(contentType))
            .baseUrl(CoinsEndpoints.BASE_URL)
            .client(client)
            .build()
    }

    @[Provides Singleton]
    fun provideCoinsApi(
        retrofit: Retrofit,
    ): CoinStatsApi {
        return retrofit.create(CoinStatsApi::class.java)
    }
}