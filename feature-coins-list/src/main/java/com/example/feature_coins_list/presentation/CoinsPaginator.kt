package com.example.feature_coins_list.presentation

import com.example.core.utils.Resource
import com.example.feature_coins_list.domain.usecase.GetCoinsUseCase
import com.example.feature_coins_list.presentation.mapper.toPresentationModel
import com.example.feature_coins_list.presentation.model.CoinDisplayable
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

const val PAGES_LIMIT = 300

class CoinsPaginator @AssistedInject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    @Assisted private inline val onRequestSuccessReturnSize: (data: List<CoinDisplayable>) -> Int,
    @Assisted private inline val onRequestError: (message: String?) -> Unit,
    @Assisted private inline val onRequestLoading: () -> Unit,
    @Assisted private val coroutineScope: CoroutineScope,
) {

    private val isLoading = MutableStateFlow(false)
    private val endReached = MutableStateFlow(false)
    private val skip = MutableStateFlow(0)

    internal suspend fun getCoins(page: Int = 1) {
        getCoinsUseCase(page)
            .onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { data ->
                            val listSize = onRequestSuccessReturnSize(data.toPresentationModel())
                            skip.value = listSize
                            endReached.value = data.isEmpty() || listSize >= PAGES_LIMIT
                            isLoading.value = false
                        }
                    }

                    is Resource.Error -> {
                        onRequestError(result.t?.message)
                    }

                    is Resource.Loading -> {
                        onRequestLoading()
                        isLoading.value = true
                    }
                }
            }.launchIn(coroutineScope)
    }

    internal suspend fun getCoinsPaginated() {
        if (endReached.value) {
            return
        }
        getCoins(skip.value)
    }

    @AssistedFactory
    interface GamesPaginatorFactory {
        fun create(
            onRequestSuccessAndGetSize: (data: List<CoinDisplayable>) -> Int,
            onRequestError: (message: String?) -> Unit,
            onRequestLoading: () -> Unit,
            coroutineScope: CoroutineScope,
        ): CoinsPaginator
    }
}