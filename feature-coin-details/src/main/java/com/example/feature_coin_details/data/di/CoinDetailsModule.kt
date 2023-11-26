package com.example.feature_coin_details.data.di

import com.example.feature_coin_details.data.repository.CoinStatsRepositoryImpl
import com.example.feature_coin_details.data.repository.CoinsTrackingRepositoryImpl
import com.example.feature_coin_details.domain.repository.CoinsStatsRepository
import com.example.feature_coin_details.domain.repository.CoinsTrackingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object CoinDetailsModule {

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {
        @[Binds Singleton]
        fun bindCoinsTrackingRepository(impl: CoinsTrackingRepositoryImpl): CoinsTrackingRepository

        @[Binds Singleton]
        fun bindCoinStatsRepository(impl: CoinStatsRepositoryImpl): CoinsStatsRepository
    }
}