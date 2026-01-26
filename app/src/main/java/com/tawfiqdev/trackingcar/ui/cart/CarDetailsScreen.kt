package com.tawfiqdev.trackingcar.ui.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tawfiqdev.design_system.theme.Colors

@Composable
fun CarDetailsScreen(
    userId: Int,
    userList: List<Car>,
) {
    val user = userList.firstOrNull { it.id == userId }
        ?: return
    Scaffold(containerColor = Colors.White) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CarPicture(user, 200.dp)
            CarContent(user, Alignment.CenterHorizontally)
        }
    }
}
