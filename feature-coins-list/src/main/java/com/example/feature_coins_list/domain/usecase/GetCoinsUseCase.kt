package com.example.feature_coins_list.domain.usecase

import com.example.core.utils.Resource
import com.example.feature_coins_list.domain.model.Coin
import com.example.feature_coins_list.domain.repository.CoinsStatsRepository
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

class GetCoinsUseCase @Inject constructor(
    private val coinstatsRepository: CoinsStatsRepository,
) {
    suspend operator fun invoke(page: Int): Flow<Resource<List<Coin>>> {
        val result = coinstatsRepository
            .getCoins(page)
            .map<List<Coin>, Resource<List<Coin>>> {
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
            emit(Resource.Loading<List<Coin>>())
            emitAll(result)
        }
    }
}