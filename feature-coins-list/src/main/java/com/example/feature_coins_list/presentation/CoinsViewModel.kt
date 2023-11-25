package com.example.feature_coins_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.navigation.NavigationManager
import com.example.feature_coins_list.presentation.model.CoinDisplayable
import com.example.feature_coins_list.presentation.state.CoinsListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val coinsPaginatorFactory: CoinsPaginator.GamesPaginatorFactory,
) : ViewModel() {

    private val _state = MutableStateFlow(CoinsListState())
    val state = _state.asStateFlow()

    private val coins
        get() = _state.value.coins

    private val paginator by lazy {
        coinsPaginatorFactory.create(
            onRequestSuccessAndGetSize = {
                onRequestSuccess(it)
            },
            onRequestError = {
                onRequestError(it)
            },
            onRequestLoading = {
                onRequestLoading()
            },
            coroutineScope = viewModelScope,
        )
    }

    init {
        viewModelScope.launch {
            paginator.getCoins()
        }
    }

    suspend fun onCoinsUpload() {
        paginator.getCoinsPaginated()
    }

    private fun onRequestSuccess(data: List<CoinDisplayable>): Int {
        _state.update {
            it.copy(
                coins = it.coins + data,
                isNewPageLoading = false,
                error = ""
            )
        }
        return _state.value.coins.size
    }

    private fun onRequestLoading() {
        _state.update {
            it.copy(
                isNewPageLoading = true
            )
        }
    }

    private fun onRequestError(message: String?) {
        _state.update {
            it.copy(error = message ?: "Unexpected Error")
        }
    }

}