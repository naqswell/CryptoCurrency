package com.example.feature_coins_list.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.feature_coins_list.presentation.components.CoinsPaginationContent

@Composable
internal fun CoinsRoute(
    viewModel: CoinsViewModel = hiltViewModel()
) {
    val uiState = viewModel.state.collectAsStateWithLifecycle()
    val coins = uiState.value.coins
    val isNewPageLoading = uiState.value.isNewPageLoading

    CoinsPaginationContent(
        coins = coins,
        isLoading = isNewPageLoading,
        onItemlick = { },
        getItems = { viewModel.onCoinsUpload() }
    )

}