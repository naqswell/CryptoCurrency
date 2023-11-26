package com.example.feature_coins_tracking_list.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.feature_coins_tracking_list.presentation.components.CoinTrackingContent

@Composable
fun CoinsTrackingRoute(
    viewModel: CoinsTrackingViewModel = hiltViewModel()
) {
    val uiState = viewModel.coinsTrackingState.collectAsStateWithLifecycle()
    val coins = uiState.value.coinsTrackingList

    CoinTrackingContent(coins) {
        viewModel.onNavigateCoinDetails(it)
    }

}