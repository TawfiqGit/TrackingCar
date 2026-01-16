package com.tawfiqdev.trackingcar.ui.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tawfiqdev.trackingcar.navigation.Screen
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import com.tawfiqdev.design_system.R
import com.tawfiqdev.design_system.components.AppIcon
import com.tawfiqdev.design_system.objets.AppColor

@Composable
fun SplashScreen(
    navController: NavHostController,
) {
    val alpha = remember { Animatable(0f) }
    val scale = remember { Animatable(0.85f) }
    val rotation = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        coroutineScope {
            val fadeZoomJob = launch {
                alpha.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(durationMillis = 700, easing = LinearOutSlowInEasing)
                )
            }

            val scaleJob = launch {
                scale.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(durationMillis = 700, easing = LinearOutSlowInEasing)
                )
            }

            val rotationJob = launch {
                rotation.animateTo(
                    targetValue = 720f,
                    animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing)
                )
            }
            fadeZoomJob.join()
            scaleJob.join()
            rotationJob.join()
        }
        navController.navigate(Screen.Login.route)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.White),
        contentAlignment = Alignment.Center
    ) {
        AppIcon(
            modifier = Modifier.graphicsLayer {
                this.alpha = alpha.value
                scaleX = scale.value
                scaleY = scale.value
                rotationZ = rotation.value
            },
            painter = painterResource(R.drawable.app_icon),
            size = 200.dp,
            tint = AppColor.Matisse
        )
    }
}