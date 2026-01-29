package com.tawfiqdev.design_system.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tawfiqdev.design_system.theme.Colors.GreyLight

@Composable
fun DividerLight() {
    HorizontalDivider(
        modifier = Modifier.padding(start = 52.dp),
        thickness = 0.8.dp,
        color = GreyLight
    )
}

@Composable
fun DividerFull() {
    HorizontalDivider(
        modifier = Modifier.padding(start = 52.dp, end = 52.dp, top = 16.dp, bottom = 16.dp),
        thickness = 0.8.dp,
        color = GreyLight
    )
}