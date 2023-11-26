package com.example.feature_coins_tracking_list.domain.usecase

import com.example.core.utils.Resource
import com.example.feature_coins_tracking_list.domain.model.CoinTracking
import com.example.feature_coins_tracking_list.domain.repository.CoinsTrackingRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.retryWhen
import java.io.IOException

private const val RETRY_TIME_IN_MILLIS = 15_000L

fun interface GetAllCoinsTrackingUseCase : () -> Flow<Resource<List<CoinTracking>>>

fun getAllCoinsTrackingUseCase(
    coinsTrackingRepository: CoinsTrackingRepository
): Flow<Resource<List<CoinTracking>>> {
    val result = coinsTrackingRepository
        .getCoinsTracking()
        .map<List<CoinTracking>, Resource<List<CoinTracking>>> {
            Resource.Success(it)
        }
        .retryWhen { cause, _ ->
            if (cause is IOException) {
                emit(Resource.Error(cause))

                delay(RETRY_TIME_IN_MILLIS)
                true
            } else {
                false
            }
        }
        .catch {
            emit(Resource.Error(it))
        }

    return flow {
        emit(Resource.Loading<List<CoinTracking>>())
        emitAll(result)
    }
}