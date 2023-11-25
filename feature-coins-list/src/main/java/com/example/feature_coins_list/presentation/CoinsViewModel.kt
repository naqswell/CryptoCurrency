package com.example.feature_coins_list.presentation

import androidx.lifecycle.ViewModel
import com.example.core.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
) : ViewModel() {
}