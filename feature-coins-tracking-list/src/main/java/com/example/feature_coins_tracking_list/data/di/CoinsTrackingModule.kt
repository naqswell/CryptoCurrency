package com.example.feature_coins_tracking_list.data.di

import com.example.feature_coins_tracking.data.repository.CoinsTrackingRepositoryImpl
import com.example.feature_coins_tracking_list.domain.repository.CoinsTrackingRepository
import com.example.feature_coins_tracking_list.domain.usecase.GetAllCoinsTrackingUseCase
import com.example.feature_coins_tracking_list.domain.usecase.getAllCoinsTrackingUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object CoinsTrackingModule {

    @Provides
    fun providesGetAllCoinsTrackingUseCase(
        coinsTrackingRepository: CoinsTrackingRepository
    ): GetAllCoinsTrackingUseCase = GetAllCoinsTrackingUseCase {
        getAllCoinsTrackingUseCase(coinsTrackingRepository)
    }


    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {
        @[Binds Singleton]
        fun bindCoinTrackingRepository(repositoryImpl: CoinsTrackingRepositoryImpl): CoinsTrackingRepository
    }

}