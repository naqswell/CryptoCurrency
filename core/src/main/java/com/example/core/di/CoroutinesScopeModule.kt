package com.example.core.coroutines.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import timber.log.Timber
import javax.inject.Qualifier
import javax.inject.Singleton

@[Retention Qualifier]
annotation class MainImmediateScope

@[Retention Qualifier]
annotation class IoScope

@[Retention Qualifier]
annotation class DefaultScope


@Module
@InstallIn(SingletonComponent::class)
internal object CoroutinesScopeModule {

    @[Singleton Provides]
    fun providesCoroutineExceptionHandler(): CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            Timber.e(throwable)
        }


    @MainImmediateScope
    @[Singleton Provides]
    fun provideMainImmediateScope(
        @MainImmediateDispatcher mainImmediateDispatcher: CoroutineDispatcher,
        exceptionHandler: CoroutineExceptionHandler
    ): CoroutineScope = CoroutineScope(SupervisorJob() + mainImmediateDispatcher + exceptionHandler)


    @IoScope
    @[Singleton Provides]
    fun provideIoScope(
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
        exceptionHandler: CoroutineExceptionHandler,
    ): CoroutineScope = CoroutineScope(SupervisorJob() + ioDispatcher + exceptionHandler)


    @DefaultScope
    @[Singleton Provides]
    fun provideDefaultScope(
        @DefaultDispatcher defaultDispatcher: CoroutineDispatcher,
        exceptionHandler: CoroutineExceptionHandler,
    ): CoroutineScope = CoroutineScope(SupervisorJob() + defaultDispatcher + exceptionHandler)
}