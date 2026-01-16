package com.tawfiqdev.trackingcar.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Cart : Screen("car_screen")
    object Reservation : Screen("reservation_screen")
    object Profile : Screen("profile_screen")
}