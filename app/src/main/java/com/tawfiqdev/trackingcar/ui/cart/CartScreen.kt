package com.tawfiqdev.trackingcar.ui.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tawfiqdev.design_system.components.AppText
import com.tawfiqdev.design_system.components.Header
import com.tawfiqdev.design_system.components.SquareActionButton
import com.tawfiqdev.design_system.theme.Colors
import com.tawfiqdev.design_system.theme.Colors.AppBlue
import com.tawfiqdev.design_system.utils.Baseline5_1

@Composable
fun CartScreen(
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

@Composable
fun Header(
    userName: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppBlue)
            .padding(horizontal = Baseline5_1, vertical = Baseline5_1)
    ) {
        Surface(
            color = AppBlue,
            tonalElevation = 0.dp,
            shadowElevation = 0.dp,
            modifier = modifier
                .fillMaxWidth()
                .height(54.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(modifier = Modifier.size(56.dp)) {
                    Icon(
                        imageVector = Icons.Outlined.AccountCircle,
                        contentDescription = "Profil",
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .wrapContentHeight(align = Alignment.CenterVertically),
                    text = userName,
                    color = Color.White,
                    fontSize = 24.sp,
                    overflow = TextOverflow.Ellipsis
                )

                SquareActionButton(
                    modifier = Modifier.size(52.dp).padding(2.dp),
                    color = Colors.SoftBlue,
                    onClick = {},
                    icon = {
                        AppText(text = "≡", color= Colors.Black)
                    }
                )
            }
        }
    }
}