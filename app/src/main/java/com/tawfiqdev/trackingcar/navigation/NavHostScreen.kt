package com.tawfiqdev.trackingcar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tawfiqdev.trackingcar.ui.auth.LoginScreen
import com.tawfiqdev.trackingcar.ui.dashboard.DashboardScreen
import com.tawfiqdev.trackingcar.ui.splash.SplashScreen

@Composable
fun NavHostScreen(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Dashboard.route) {
            DashboardScreen(
                userName = "Florent Delestaing",
                onBorrowVehicle = {  },
                onReturnVehicle = { },
                onHistory = { },
                onQuit = { navController.popBackStack() }
            )
        }
    }
}