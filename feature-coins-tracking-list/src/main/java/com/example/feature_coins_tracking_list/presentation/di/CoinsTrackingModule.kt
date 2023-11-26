package com.example.feature_coins_tracking_list.presentation.di

import com.example.core.navigation.NavigationFactory
import com.example.feature_coins_tracking_list.presentation.CoinsTrackingNavigationFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal  interface CoinsTrackingModule {

    @[Singleton Binds IntoSet]
    fun bindCoinsTrackingNavigationFactory(factory: CoinsTrackingNavigationFactory): NavigationFactory
}