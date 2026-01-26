package com.tawfiqdev.trackingcar.ui.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tawfiqdev.design_system.theme.Colors

const val USER_ID_KEY = "userId"

@Composable
fun CartScreen(){
    Box (Modifier
        .fillMaxSize()
        .background(Colors.White)
    ){
        UsersApplication(userList)
    }
}

@Composable
fun UsersApplication(
    userList: List<Car>
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "userList"
    ) {
        composable("userList") {
            CarListScreen(
                userList = userList,
                onUserClick = {
                    navController.navigate("userDetails/${it.id}")
                }
            )
        }
        composable(
            route = "userDetails/{$USER_ID_KEY}",
            arguments = listOf(
                navArgument(USER_ID_KEY) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val userId = backStackEntry.arguments
                ?.getInt(USER_ID_KEY)
                ?: return@composable

            CarDetailsScreen(
                userId = userId,
                userList = userList,
            )
        }
    }
}