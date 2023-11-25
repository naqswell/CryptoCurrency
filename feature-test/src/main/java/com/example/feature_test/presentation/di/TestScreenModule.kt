package com.example.feature_test.presentation.di

import com.example.core.navigation.NavigationFactory
import com.example.feature_test.presentation.TestScreenFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface TestSingletonModule {

    @[Singleton Binds IntoSet]
    fun bindTestScreenNavigationFactory(factory: TestScreenFactory): NavigationFactory
}