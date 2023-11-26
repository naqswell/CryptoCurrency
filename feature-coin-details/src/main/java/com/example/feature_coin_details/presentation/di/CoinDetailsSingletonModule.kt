package com.example.feature_coin_details.presentation.di

import com.example.core.navigation.NavigationFactory
import com.example.feature_coin_details.presentation.CoinDetailsNavigationFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface CoinsSingletonModule {

    @[Singleton Binds IntoSet]
    fun bindCoinsNavGraphFactory(factory: CoinDetailsNavigationFactory): NavigationFactory
}