package com.example.cache_coins.di

import android.content.Context
import androidx.room.Room
import com.example.cache_coins.database.CoinsTrackingDataBase
import com.example.cache_coins.dao.CoinsTrackingDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val COINS_TRACKING_DATABASE_NAME = "coins_tracking_database_name"


@Module
@InstallIn(SingletonComponent::class)
internal object CoinsTrackingDBModule {

    @[Singleton Provides]
    fun providesCoinsTrackingDataBase(
        @ApplicationContext context: Context
    ): CoinsTrackingDataBase =
        Room.databaseBuilder(
            context,
            CoinsTrackingDataBase::class.java,
            COINS_TRACKING_DATABASE_NAME
        ).build()


    @[Singleton Provides]
    fun provideCoinsTrackingDao(dataBase: CoinsTrackingDataBase): CoinsTrackingDao {
        return dataBase.coinsTrackingDao()
    }
}