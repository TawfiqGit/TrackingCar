package com.tawfiqdev.design_system.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tawfiqdev.design_system.theme.SmallRoundedCornerShape

@Composable
fun Icons(
    modifier: Modifier = Modifier,
    painter: Painter,
    size: Dp = 24.dp,
    tint: Color = MaterialTheme.colorScheme.onSurface
) {
    Icon(
        modifier = modifier
            .size(size)
            .clip(SmallRoundedCornerShape),
        painter = painter,
        contentDescription = null,
        tint = tint
    )
}