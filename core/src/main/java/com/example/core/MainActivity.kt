package com.example.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.core.design.AppTheme
import com.example.core.navigation.NavigationFactory
import com.example.core.navigation.NavigationHost
import com.example.core.navigation.NavigationManager
import com.example.core.navigation.destinations.BackDestination
import com.example.core.utils.collectWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var navigationGraphFactories: @JvmSuppressWildcards Set<NavigationFactory>
    @Inject lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            AppTheme(darkTheme = true) {
                val navController = rememberNavController()
                Scaffold { innerPadding ->
                    NavigationHost(
                        navController = navController,
                        factories = navigationGraphFactories,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                navigationManager
                    .navigationEvent
                    .collectWithLifecycle(
                        key = navController,
                    ) { navCommand ->
                        when (navCommand.destination) {
                            BackDestination.route -> navController.navigateUp()
                            else -> {
                                navController.navigate(
                                    navCommand.destination,
                                    navCommand.configuration
                                )
                            }
                        }
                    }
            }
        }
    }
}