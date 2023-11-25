package com.example.feature_coins_list.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core.navigation.NavigationFactory
import com.example.core.navigation.destinations.CoinsDestination
import javax.inject.Inject

class CoinsListNavigationFactory @Inject constructor() : NavigationFactory {
    override fun create(builder: NavGraphBuilder) {
        builder.composable(route = CoinsDestination.route) {
            CoinsRoute()
        }
    }
}