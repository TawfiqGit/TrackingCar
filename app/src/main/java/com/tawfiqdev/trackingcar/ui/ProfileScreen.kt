package com.tawfiqdev.trackingcar.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tawfiqdev.design_system.components.Header
import com.tawfiqdev.design_system.theme.Colors

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    userName: String,
){
    Box (
        modifier = Modifier.fillMaxSize().background(Colors.White),
        contentAlignment = Alignment.TopCenter
    ){
        Header(userName = userName)
    }
}