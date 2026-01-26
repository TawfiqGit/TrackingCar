package com.tawfiqdev.trackingcar.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tawfiqdev.design_system.R
import com.tawfiqdev.design_system.components.CardActionButton
import com.tawfiqdev.design_system.components.DividerFull
import com.tawfiqdev.design_system.components.DividerLight
import com.tawfiqdev.design_system.components.InlineTextContent
import com.tawfiqdev.design_system.theme.Colors.AppBlue
import com.tawfiqdev.design_system.theme.Colors.AppGreen
import com.tawfiqdev.design_system.theme.Colors.AppRed
import com.tawfiqdev.design_system.theme.Colors.AppYellow
import com.tawfiqdev.design_system.theme.Colors.Black
import com.tawfiqdev.design_system.theme.Colors.GreyDark
import com.tawfiqdev.design_system.theme.Colors.White
import com.tawfiqdev.trackingcar.ui.cart.VehicleStatus

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    vehicleStatus: VehicleStatus,
    onBorrowVehicle: () -> Unit,
    onReturnVehicle: () -> Unit,
    onSearchCar: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize().background(White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp),
        ) {
            CardActionButton(
                title = stringResource(R.string.button_search_car),
                iconId = R.drawable.outline_car_rental,
                contentColor = AppYellow,
                borderColor = AppYellow,
                onClick = {
                    onSearchCar()
                }
            )

            CardActionButton(
                title = stringResource(R.string.button_emprunter),
                iconId = R.drawable.outline_car,
                contentColor = AppGreen,
                borderColor = AppGreen,
                onClick = {
                    onBorrowVehicle()
                }
            )

            CardActionButton(
                title = stringResource(R.string.button_return),
                iconId = R.drawable.outline_car_rental,
                contentColor = AppRed,
                borderColor = AppRed,
                onClick = {
                    onReturnVehicle()
                }
            )
        }
        DividerFull()

        VehicleStatusCard(
            status = vehicleStatus,
            modifier = Modifier.padding(16.dp)
        )
    }
}


@Composable
fun VehicleStatusCard(
    status: VehicleStatus,
    modifier: Modifier = Modifier,
    onFuelClick: () -> Unit = {},
    onLocationClick: () -> Unit = {},
    onTimeClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            StatusRow(
                icon = ImageVector.vectorResource(R.drawable.station_essence),
                iconTint = AppBlue,
                label = "Carburant",
                value = "${status.fuelPercent}%",
                onClick = onFuelClick
            )

            DividerLight()

            StatusRow(
                icon = Icons.Default.LocationOn,
                iconTint = AppBlue,
                label = "Position",
                value = status.location,
                onClick = onLocationClick
            )

            DividerLight()

            StatusRow(
                icon = ImageVector.vectorResource(R.drawable.time_icon),
                iconTint = AppBlue,
                label = "Temps restant",
                value = status.remainingTime,
                onClick = onTimeClick
            )
        }
    }
}

@Composable
private fun StatusRow(
    icon: ImageVector,
    iconTint: androidx.compose.ui.graphics.Color,
    label: String,
    value: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(22.dp)
        )


        Spacer(modifier = Modifier.width(12.dp))

        InlineTextContent(text = "$label : ")

        InlineTextContent(
            text = value,
            color = Black,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = GreyDark
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DashboardScreenPreview(){
    HomeScreen(
        onBorrowVehicle = {  },
        onReturnVehicle = { },
        onSearchCar = { },
        vehicleStatus = VehicleStatus(
            fuelPercent = 85,
            location = "Parking B",
            remainingTime = "2h 30m"
        )
    )
}