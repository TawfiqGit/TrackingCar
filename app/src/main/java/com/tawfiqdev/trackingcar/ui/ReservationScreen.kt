package com.tawfiqdev.trackingcar.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tawfiqdev.design_system.theme.Colors

@Composable
fun ReservationScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(Colors.White),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Reservation Screen",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}