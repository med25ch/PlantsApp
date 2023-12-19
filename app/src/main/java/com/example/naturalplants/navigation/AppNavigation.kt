package com.example.naturalplants.navigation

enum class Screen {
    HOME,
    DETAILS_SCREEN
}

sealed class NavigationItem(val route: String) {
    object HomeScreen : NavigationItem(Screen.HOME.name)
    object DetailsScreen : NavigationItem(Screen.DETAILS_SCREEN.name)
}