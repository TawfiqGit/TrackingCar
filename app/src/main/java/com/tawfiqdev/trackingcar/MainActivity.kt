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
import com.tawfiqdev.trackingcar.navigation.Screen
import com.tawfiqdev.trackingcar.ui.CartScreen
import com.tawfiqdev.trackingcar.ui.ProfileScreen
import com.tawfiqdev.trackingcar.ui.ReservationScreen
import com.tawfiqdev.trackingcar.ui.DashboardScreen
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
        val userNameProfile = "Florent Delestaing"

        val graph =
            navController.createGraph(startDestination = Screen.Home.route) {
                composable(route = Screen.Home.route) {it ->
                    DashboardScreen(
                        userName = userNameProfile,
                        onBorrowVehicle = {  },
                        onReturnVehicle = { },
                        onHistory = { },
                        onQuit = { navController.popBackStack() }
                    )
                }
                composable(route = Screen.Cart.route) {it ->
                    CartScreen(userName = userNameProfile)
                }
                composable(route = Screen.Reservation.route) {it ->
                    ReservationScreen(userName = userNameProfile)
                }
                composable(route = Screen.Profile.route) { it ->
                    ProfileScreen(userName = userNameProfile)
                }
            }
        NavHost(
            navController = navController,
            graph = graph,
            modifier = Modifier.padding(innerPadding)
        )
    }
}