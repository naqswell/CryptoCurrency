package com.example.feature_coins_tracking_list.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core.navigation.NavigationFactory
import com.example.core.navigation.destinations.CoinTracking
import javax.inject.Inject

class CoinsTrackingNavigationFactory @Inject constructor() : NavigationFactory {
    override fun create(builder: NavGraphBuilder) {
        builder.composable(
            route = CoinTracking.route
        ) {
            CoinsTrackingRoute()
        }
    }
}