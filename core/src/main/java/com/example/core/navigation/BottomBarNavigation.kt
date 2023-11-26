package com.example.core.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavOptions
import com.example.core.R
import com.example.core.navigation.destinations.CoinTracking
import com.example.core.navigation.destinations.CoinsDestination

@Composable
fun BottomBarNavigation(
    navigationManager: NavigationManager,
    visible: Boolean = true,
) {

    val coinsList = object : BottomBarItem {
        override val iconResId: Int
            get() = R.drawable.ic_list

        override fun onItemClick() = navigationManager.navigate(object : NavigationCommand {
            override val destination: String = CoinsDestination.route
            override val configuration: NavOptions
                get() = NavOptions.Builder()
                    .setPopUpTo(0, true)
                    .setLaunchSingleTop(true)
                    .build()
        })
    }

    val coinsTracking = object : BottomBarItem {
        override val iconResId: Int
            get() = R.drawable.ic_star

        override fun onItemClick() = navigationManager.navigate(object : NavigationCommand {
            override val destination: String = CoinTracking.route
            override val configuration: NavOptions
                get() = NavOptions.Builder()
                    .setPopUpTo(0, true)
                    .setLaunchSingleTop(true)
                    .build()
        })
    }


    val bottomItems: List<BottomBarItem> = listOf(
        coinsList,
        coinsTracking
    )

    if (visible) {
        BottomAppBar(
            actions = {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    bottomItems.forEach { item ->
                        IconButton(
                            onClick = { item.onItemClick() }
                        ) {
                            Icon(
                                painter = painterResource(item.iconResId),
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        )
    }

}