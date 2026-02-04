package com.tawfiqdev.trackingcar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.tawfiqdev.design_system.components.Header
import com.tawfiqdev.design_system.theme.TrackingCarTheme
import com.tawfiqdev.trackingcar.navigation.BottomNavigationBar
import com.tawfiqdev.trackingcar.navigation.Screen
import com.tawfiqdev.trackingcar.ui.BorrowCarScreen
import com.tawfiqdev.trackingcar.ui.HomeScreen
import com.tawfiqdev.trackingcar.ui.ProfileScreen
import com.tawfiqdev.trackingcar.ui.ReservationScreen
import com.tawfiqdev.trackingcar.ui.cart.CartScreen
import com.tawfiqdev.trackingcar.ui.cart.VehicleStatus
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
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val showChrome = currentRoute != Screen.BorrowCar.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if (showChrome) {
                Header(
                    title = "Tawfiq MOUTTALIF",
                    isEnableAction = true
                )
            }
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        val graph =
            navController.createGraph(startDestination = Screen.Home.route) {
                composable(route = Screen.Home.route) {it ->
                    HomeScreen(
                        onBorrowVehicle = {
                            navController.navigate(Screen.BorrowCar.route)
                        },
                        onReturnVehicle = { },
                        onSearchCar = { },
                        vehicleStatus  = VehicleStatus(
                            fuelPercent = 85,
                            location = "Parking B",
                            remainingTime = "2h 30m"
                        )
                    )
                }
                composable(route = Screen.Cart.route) {it ->
                    CartScreen()
                }
                composable(route = Screen.Reservation.route) {it ->
                    ReservationScreen()
                }
                composable(route = Screen.Profile.route) { it ->
                    ProfileScreen()
                }
                composable(route = Screen.BorrowCar.route) {
                    BorrowCarScreen(
                        onBackClick = { navController.navigateUp() }
                    )
                }
            }
        NavHost(
            navController = navController,
            graph = graph,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}