package com.example.feature_coin_details.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core.navigation.NavigationFactory
import com.example.core.navigation.destinations.CoinDetailsDestination
import javax.inject.Inject

class CoinDetailsNavigationFactory @Inject constructor() : NavigationFactory {
    override fun create(builder: NavGraphBuilder) {
        builder.composable(route = CoinDetailsDestination.route) {
            CoinDetailsRoute()
        }
    }
}