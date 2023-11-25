package com.example.feature_coins_list.presentation.state

import com.example.feature_coins_list.presentation.model.CoinDisplayable

data class CoinsListState(
    val isNewPageLoading: Boolean = false,
    val coins: List<CoinDisplayable> = emptyList(),
    val error: String = ""
)