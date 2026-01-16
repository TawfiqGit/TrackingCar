package com.tawfiqdev.trackingcar.ui.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tawfiqdev.design_system.R
import com.tawfiqdev.design_system.components.ActionOutlinedButton
import com.tawfiqdev.design_system.theme.Colors.AppBlue
import com.tawfiqdev.design_system.theme.Colors.AppGreen
import com.tawfiqdev.design_system.theme.Colors.AppRed
import com.tawfiqdev.design_system.theme.Colors.AppYellow

@Composable
fun DashboardScreen(
    userName: String,
    onBorrowVehicle: () -> Unit,
    onReturnVehicle: () -> Unit,
    onHistory: () -> Unit,
    onQuit: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
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

            ActionOutlinedButton(
                text = "Rendre le véhicule",
                iconId = R.drawable.outline_car_rental,
                borderColor = AppGreen,
                contentColor = AppGreen,
                onClick = onReturnVehicle
            )

            ActionOutlinedButton(
                text = "Voir mon historique",
                iconId = R.drawable.outline_history,
                borderColor = AppYellow,
                contentColor = AppYellow,
                onClick = onHistory
            )

            ActionOutlinedButton(
                text = "Quitter",
                iconId = R.drawable.outline_logout,
                borderColor = AppRed,
                contentColor = AppRed,
                onClick = onQuit
            )
        }
    }
}

@Composable
private fun Header(
    userName: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = AppBlue,
        tonalElevation = 0.dp,
        shadowElevation = 0.dp,
        modifier = modifier
            .fillMaxWidth()
            .height(162.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 22.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(78.dp)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    shape = CircleShape,
                    color = Color.Transparent,
                    border = BorderStroke(2.dp, Color.White),
                    modifier = Modifier.fillMaxSize()
                ) {}

                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Profil",
                    tint = Color.White,
                    modifier = Modifier.size(70.dp)
                )
            }
            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = userName,
                color = Color.White,
                fontSize = 24.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
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