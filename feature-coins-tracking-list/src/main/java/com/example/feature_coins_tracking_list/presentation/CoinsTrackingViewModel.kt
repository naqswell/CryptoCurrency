package com.example.feature_coins_tracking_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.navigation.NavigationCommand
import com.example.core.navigation.NavigationManager
import com.example.core.navigation.destinations.CoinDetailsDestination
import com.example.core.utils.Resource
import com.example.feature_coins_tracking_list.domain.model.CoinTracking
import com.example.feature_coins_tracking_list.domain.usecase.GetAllCoinsTrackingUseCase
import com.example.feature_coins_tracking_list.presentation.mapper.toPresentationModel
import com.example.feature_coins_tracking_list.presentation.state.CoinsTrackingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CoinsTrackingViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val getAllCoinsTrackingUseCase: GetAllCoinsTrackingUseCase,
) : ViewModel() {

    private val _coinsTrackingState = MutableStateFlow(CoinsTrackingState())
    val coinsTrackingState = _coinsTrackingState.asStateFlow()

    init {
        getAllCoinsTracking()
    }

    fun onNavigateCoinDetails(coinId: String) {
        navigationManager.navigate(object : NavigationCommand {
            override val destination: String
                get() {
                    val args = mapOf(CoinDetailsDestination.ARGS_KEYS.COIN_ID to coinId)
                    return CoinDetailsDestination.getRouteWithArgs(args)
                }
        })
    }

    private fun getAllCoinsTracking() {
        _coinsTrackingState.update { it.copy(isLoading = true) }
        getAllCoinsTrackingUseCase()
            .onEach { resourse ->
                when (resourse) {
                    is Resource.Success -> {
                        resourse.data?.let { data -> onGetAllCoinsTrackingSuccess(data) }
                    }

                    is Resource.Error -> { onGetAllCoinsTrackingError(resourse.t?.message) }

                    is Resource.Loading -> {}
                }
            }.launchIn(viewModelScope)
    }

    private fun onGetAllCoinsTrackingSuccess(coinsTracking: List<CoinTracking>) {
        _coinsTrackingState.update {
            it.copy(
                coinsTrackingList = coinsTracking.map { domain -> domain.toPresentationModel() }
            )
        }
    }

    private fun onGetAllCoinsTrackingError(message: String?) {
        _coinsTrackingState.update {
            it.copy(error = message ?: "Unexpected Error")
        }
    }
}