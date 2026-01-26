package com.tawfiqdev.design_system.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.tawfiqdev.design_system.theme.Colors
import com.tawfiqdev.design_system.theme.RobotoFamily

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onBackground,
    textAlignment : TextAlign = TextAlign.Start,
    fontSize: TextUnit = 14.sp,
    fontWeight : FontWeight = FontWeight.Normal,
    isEnable : Boolean = true,
    onClick: () -> Unit = {},
) {
    Text(
        modifier = modifier.clickable(enabled = isEnable) { if (isEnable) onClick() },
        text = text,
        fontSize = fontSize,
        color = color,
        textAlign = textAlignment,
        fontWeight = fontWeight,
        fontFamily = RobotoFamily,
    )
}

@Composable
fun InlineTextContent(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Colors.AppBlue,
    fontSize: TextUnit = 14.sp,
    fontWeight : FontWeight = FontWeight.Normal,
    isEnable : Boolean = true,
    onClick: () -> Unit = {},
) {
    Text(
        modifier = modifier.clickable(enabled = isEnable) { if (isEnable) onClick() },
        text = text,
        textAlign = TextAlign.Start,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontFamily = RobotoFamily,
    )
}

@Preview
@Composable
fun AppText() {
    InlineTextContent(text = "Tawfiq")
}