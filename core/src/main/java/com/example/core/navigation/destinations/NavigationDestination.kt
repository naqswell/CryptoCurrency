package com.example.core.navigation.destinations

sealed class NavigationDestination {
    abstract val route: String

    final fun getRouteWithArgs(args: Map<String, String>): String {
        var result: String = route
        args.forEach { (key, value) ->
            result = result.replace("{$key}", value)
        }
        return result
    }
}