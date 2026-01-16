package com.tawfiqdev.trackingcar.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Login : Screen("login_screen")

    object Dashboard : Screen("dashboard_screen")
}