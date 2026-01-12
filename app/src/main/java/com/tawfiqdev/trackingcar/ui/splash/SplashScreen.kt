package com.tawfiqdev.trackingcar.ui.splash

import android.R
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tawfiqdev.trackingcar.navigation.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow

@Composable
fun SplashScreen (navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        BackgroundSplash(
            painter = painterResource(id = R.drawable.sym_contact_card),
            contentDescription = "Background SlashScreen",
            modifier = Modifier.align(Alignment.Center)
        )
       // navController.navigate(Screen.Login.route)
    }
}

@Composable
fun BackgroundSplash(
    isReadyFlow: StateFlow<Boolean>,
    onFinished: () -> Unit
) {
    val isReady by isReadyFlow.collectAsState()

    var alpha by remember { mutableFloatStateOf(0f) }
    var scale by remember { mutableFloatStateOf(0.85f) }
    val rotation by animateFloatAsState(
        targetValue = if (isReady) 0f else 720f,
        animationSpec = tween(1500, easing = LinearOutSlowInEasing)
    )

    // Fade-in +  zoom
    LaunchedEffect(Unit) {
        val duration = 700
        val steps = 14
        val stepDelay = duration / steps

        repeat(steps) {
            alpha += (1f - 0f) / steps
            scale += (1.0f - 0.85f) / steps
            delay(stepDelay.toLong())
        }
        alpha = 1f
        scale = 1f
    }

    LaunchedEffect(isReady) {
        if (isReady) {
            delay(3000)
            onFinished()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.GreenTeal),
        contentAlignment = Alignment.Center
    ) {
        AppIcon(
            modifier = Modifier.graphicsLayer{
                rotationZ = rotation
            },
            painter = AppIcons.AppIcon,
            size = 200.dp,
            tint = AppColor.RoseSeaShell
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = NavHostController(LocalContext.current))
}