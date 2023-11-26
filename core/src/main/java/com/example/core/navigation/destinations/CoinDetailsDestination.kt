package com.example.core.navigation.destinations

import androidx.lifecycle.SavedStateHandle

data object CoinDetailsDestination : NavigationDestination() {
    override val route: String = "coinsDetailsDestination/{${ARGS_KEYS.COIN_ID}}"

    class ArgsWrapper(val coinId: String) {
        constructor(savedStateHandle: SavedStateHandle) :
                this(checkNotNull(savedStateHandle[ARGS_KEYS.COIN_ID]) as String)
    }

    data object ARGS_KEYS {
        const val COIN_ID: String = "coinDetails_KEY"
    }
}