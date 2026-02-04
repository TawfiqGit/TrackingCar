package com.tawfiqdev.trackingcar.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tawfiqdev.design_system.R
import com.tawfiqdev.design_system.components.Header
import com.tawfiqdev.design_system.theme.Colors.AppBlue
import com.tawfiqdev.design_system.theme.Colors.AppRed
import com.tawfiqdev.design_system.theme.Colors.GreyDark
import com.tawfiqdev.design_system.theme.Colors.White

@Composable
fun BorrowCarScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White)
    ) {
        Header(
            title = stringResource(R.string.borrow_car_title),
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            isEnableAction = false
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Spacer(modifier = Modifier.height(26.dp))

            Text(
                text = stringResource(R.string.scan_qr_title),
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )

            Text(
                text = stringResource(R.string.scan_qr_subtitle),
                fontSize = 16.sp,
                color = GreyDark
            )

            Spacer(modifier = Modifier.height(12.dp))

            QrCodePlaceholder(
                modifier = Modifier
                    .size(260.dp)
                    .background(Color(0xFFEDEDED))
            )
        }
    }
}

@Composable
private fun QrCodePlaceholder(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val cells = 13
        val cellSize = size.minDimension / cells

        fun drawBlock(x: Int, y: Int, width: Int = 1, height: Int = 1) {
            drawRect(
                color = Color.Black,
                topLeft = Offset(x * cellSize, y * cellSize),
                size = Size(cellSize * width, cellSize * height)
            )
        }

        for (i in 0 until cells) {
            drawBlock(0, i)
            drawBlock(cells - 1, i)
            drawBlock(i, 0)
            drawBlock(i, cells - 1)
        }

        drawBlock(2, 2, 3, 3)
        drawBlock(cells - 5, 2, 3, 3)
        drawBlock(2, cells - 5, 3, 3)

        val pattern = listOf(
            1 to 6,
            3 to 7,
            4 to 5,
            6 to 4,
            7 to 6,
            8 to 3,
            9 to 7,
            10 to 5,
            5 to 9,
            7 to 9
        )

        pattern.forEach { (x, y) ->
            drawBlock(x, y)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BorrowVehicleScreenPreview() {
    BorrowCarScreen(onBackClick = {})
}
