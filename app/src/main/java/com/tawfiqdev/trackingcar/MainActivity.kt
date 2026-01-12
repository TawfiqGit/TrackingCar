package com.tawfiqdev.trackingcar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.tawfiqdev.trackingcar.navigation.NavHostScreen
import com.tawfiqdev.trackingcar.ui.theme.TrackingCarTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrackingCarTheme {
                val navController = rememberNavController()
                NavHostScreen(navController = navController)
            }
        }
    }
}