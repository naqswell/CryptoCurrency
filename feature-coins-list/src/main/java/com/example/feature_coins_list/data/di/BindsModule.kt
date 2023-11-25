package com.example.feature_coins_list.data.di

import com.example.feature_coins_list.data.repository.CoinsStatsRepositoryImpl
import com.example.feature_coins_list.domain.repository.CoinsStatsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CoinsListModule {
    @[Binds Singleton]
    fun bindCoinsRepository(impl: CoinsStatsRepositoryImpl): CoinsStatsRepository
}