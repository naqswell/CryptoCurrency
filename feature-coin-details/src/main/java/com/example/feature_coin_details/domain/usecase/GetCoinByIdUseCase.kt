package com.example.feature_coin_details.domain.usecase

import com.example.core.utils.Resource
import com.example.feature_coin_details.domain.model.CoinDetails
import com.example.feature_coin_details.domain.repository.CoinsStatsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.retryWhen
import java.io.IOException
import javax.inject.Inject

private const val RETRY_TIME_IN_MILLIS = 1_000L

class GetCoinByIdUseCase @Inject constructor(
    private val coinsStatsRepository: CoinsStatsRepository,
) {
    suspend operator fun invoke(id: String): Flow<Resource<CoinDetails>> {
        val result = coinsStatsRepository
            .getCoinById(id = id)
            .map<CoinDetails, Resource<CoinDetails>> {
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
            emit(Resource.Loading<CoinDetails>())
            emitAll(result)
        }
    }
}