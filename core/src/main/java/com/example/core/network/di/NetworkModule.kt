package com.example.core.network.di

import com.example.core.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {
    private const val INTERCEPTOR_LOGGING_NAME = "INTERCEPTOR_LOGGING"

    @Provides
    @Named(INTERCEPTOR_LOGGING_NAME)
    fun provideHttpLoggingInterceptor(): Interceptor {
        return if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        } else {
            noOptInterceptor()
        }
    }

    private fun noOptInterceptor(): Interceptor {
        return Interceptor { chain ->
            chain.proceed(chain.request())
        }
    }

    @[Provides Singleton]
    fun provideHttpClient(
        @Named(INTERCEPTOR_LOGGING_NAME) loggingInterceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient
            .Builder()
            .apply {
                addNetworkInterceptor(loggingInterceptor)
            }
            .build()
    }
}