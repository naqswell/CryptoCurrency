package com.example.feature_coin_details.presentation.state

import com.example.feature_coin_details.presentation.model.CoinDetailsDisplayable

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coin: CoinDetailsDisplayable? = null,
    val isTracking: Boolean = false,
    val error: String = ""
)