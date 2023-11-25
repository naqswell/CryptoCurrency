package com.example.core.coroutines.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@[Retention Qualifier]
annotation class MainImmediateDispatcher

@[Retention Qualifier]
annotation class IoDispatcher

@[Retention Qualifier]
annotation class DefaultDispatcher

@Module
@InstallIn(SingletonComponent::class)
internal object CoroutinesDispatcherModule {

    @MainImmediateDispatcher
    @[Singleton Provides]
    fun provideMainImmediateDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate

    @IoDispatcher
    @[Singleton Provides]
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @DefaultDispatcher
    @[Singleton Provides]
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}