package com.example.feature_coin_details.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_coin_details.presentation.components.CoinDetailsContent
import com.example.feature_coin_details.presentation.components.TopBarCoinDetail

@Composable
internal fun CoinDetailsRoute(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val coinState = viewModel.uiState.collectAsState()
    val coin = coinState.value.coin
    val isTracking = coinState.value.isTracking

    Scaffold(
        topBar = {
            TopBarCoinDetail(
                coinSymbol = coin?.symbol,
                icon = coin?.icon,
                onNavigateBack = { viewModel.onNavigateBack() },
                isTracking = isTracking,
                onClick = { coin?.let { viewModel.onIsCoinTrackingChanged() } })
        }
    ) { innerPadding ->
        coin?.let { coin ->
            CoinDetailsContent(
                coin = remember { coin },
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}