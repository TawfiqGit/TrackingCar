package com.tawfiqdev.trackingcar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.tawfiqdev.design_system.theme.TrackingCarTheme
import com.tawfiqdev.trackingcar.navigation.BottomNavigationBar
import com.tawfiqdev.trackingcar.navigation.NavHostScreen
import com.tawfiqdev.trackingcar.navigation.Screen
import com.tawfiqdev.trackingcar.ui.CartScreen
import com.tawfiqdev.trackingcar.ui.ProfileScreen
import com.tawfiqdev.trackingcar.ui.ReservationScreen
import com.tawfiqdev.trackingcar.ui.auth.LoginScreen
import com.tawfiqdev.trackingcar.ui.dashboard.DashboardScreen
import com.tawfiqdev.trackingcar.ui.splash.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrackingCarTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->

        val graph =
            navController.createGraph(startDestination = Screen.Home.route) {
                composable(route = Screen.Home.route) {
                    DashboardScreen(
                        userName = "Florent Delestaing",
                        onBorrowVehicle = {  },
                        onReturnVehicle = { },
                        onHistory = { },
                        onQuit = { navController.popBackStack() }
                    )
                }
                composable(route = Screen.Cart.route) {
                    CartScreen()
                }
                composable(route = Screen.Reservation.route) {
                    ReservationScreen()
                }
                composable(route = Screen.Profile.route) {
                    ProfileScreen()
                }
            }
        NavHost(
            navController = navController,
            graph = graph,
            modifier = Modifier.padding(innerPadding)
        )
    }
}