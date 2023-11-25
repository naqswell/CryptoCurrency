package com.example.core.navigation

import android.os.Parcelable
import androidx.navigation.NavOptions

interface NavigationCommand {
    val destination: String

    val parcelableArguments: Map<String, Parcelable>
        get() = emptyMap()

    val configuration: NavOptions
        get() = NavOptions.Builder().build()
}