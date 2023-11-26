package com.example.feature_coins_tracking_list.presentation.state

import com.example.feature_coins_tracking_list.presentation.model.CoinTrackingDisplayable

data class CoinsTrackingState(
    val isLoading: Boolean = false,
    val coinsTrackingList: List<CoinTrackingDisplayable> = emptyList(),
    val error: String = ""
)