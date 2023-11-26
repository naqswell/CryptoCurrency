package com.example.feature_coin_details.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.navigation.NavigationCommand
import com.example.core.navigation.NavigationManager
import com.example.core.navigation.destinations.BackDestination
import com.example.core.navigation.destinations.CoinDetailsDestination
import com.example.core.utils.Resource
import com.example.feature_coin_details.domain.model.CoinDetails
import com.example.feature_coin_details.domain.usecase.GetCoinByIdUseCase
import com.example.feature_coin_details.presentation.mapper.toPresentationModel
import com.example.feature_coin_details.presentation.state.CoinDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val navigationManager: NavigationManager,
    private val getCoinByIdUseCase: GetCoinByIdUseCase,
) : ViewModel() {

    private var currentCoin: MutableStateFlow<CoinDetails?> = MutableStateFlow(null)

    private val _uiState = MutableStateFlow(CoinDetailsState())
    val uiState = _uiState.asStateFlow()


    private val args by lazy { CoinDetailsDestination.ArgsWrapper(savedStateHandle) }

    init {
        viewModelScope.launch {
            getCoin()
            getUiState()
        }
    }

    private fun getUiState() {
        viewModelScope.launch {

            currentCoin.onEach { coin ->

                _uiState.update {
                    CoinDetailsState(coin = coin?.toPresentationModel())
                }

            }.launchIn(viewModelScope)
        }
    }

    fun onNavigateBack() {
        navigationManager.navigate(object : NavigationCommand {
            override val destination: String = BackDestination.route
        })
    }

    private suspend fun getCoin() {
        getCoinByIdUseCase(args.coinId)
            .onEach { resource ->
                when (resource) {
                    is Resource.Success -> {
                        resource.data?.let { coin ->
                            currentCoin.value = coin
                        }
                    }

                    is Resource.Error -> {
                        CoinDetailsState(error = resource.t?.message ?: "Unexpected Error")
                    }

                    is Resource.Loading -> {
                        _uiState.update { CoinDetailsState(isLoading = true) }
                    }
                }
            }.launchIn(viewModelScope)
    }

}