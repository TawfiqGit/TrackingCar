package com.tawfiqdev.trackingcar.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tawfiqdev.design_system.R
import com.tawfiqdev.design_system.components.ActionOutlinedButton
import com.tawfiqdev.design_system.components.Header
import com.tawfiqdev.design_system.theme.Colors
import com.tawfiqdev.design_system.theme.Colors.AppBlue
import com.tawfiqdev.design_system.theme.Colors.AppGreen
import com.tawfiqdev.design_system.theme.Colors.AppRed
import com.tawfiqdev.design_system.theme.Colors.AppYellow

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    userName: String,
    onBorrowVehicle: () -> Unit,
    onReturnVehicle: () -> Unit,
    onHistory: () -> Unit,
    onQuit: () -> Unit,
) {
    Column(modifier = modifier.fillMaxSize().background(Colors.White)) {
        Header(userName = userName)
        Spacer(modifier = Modifier.height(56.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 28.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ActionOutlinedButton(
                text = "Emprunter le véhicule",
                iconId = R.drawable.outline_car,
                borderColor = AppBlue,
                contentColor = AppBlue,
                onClick = onBorrowVehicle
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DashboardScreenPreview(){
    DashboardScreen(
        userName = "Florent Delestaing",
        onBorrowVehicle = {  },
        onReturnVehicle = { },
        onHistory = { },
        onQuit = { }
    )
}