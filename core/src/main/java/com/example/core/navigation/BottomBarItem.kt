package com.example.core.navigation

interface BottomBarItem {
    val iconResId: Int

    abstract fun onItemClick()
}