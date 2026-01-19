@file:JvmName("TopBarKt")

package com.tawfiqdev.design_system.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tawfiqdev.design_system.theme.Colors
import com.tawfiqdev.design_system.utils.Baseline5
import com.tawfiqdev.design_system.utils.Baseline6

@Composable
fun LocationHeader(
    userName: String,
    onSelectedLocationClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Colors.GreenRacing)
            .padding(horizontal = Baseline5, vertical = Baseline6)
    ) {
        Spacer(Modifier.height(Baseline5))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            SearchCars(
                modifier = Modifier.weight(1f)
            )
            SquareActionButton(modifier = Modifier.size(52.dp),color = Colors.RoseSeaShell, onClick = {}, icon = {
                AppText(text = "≡", color= Colors.Black)
            })
        }
    }
}

@Preview
@Composable
fun AppTopBarPreview() {
    LocationHeader(userName = "India")
}