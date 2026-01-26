package com.tawfiqdev.trackingcar.ui.cart

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.tawfiqdev.design_system.components.InlineTextContent
import com.tawfiqdev.design_system.theme.Colors

@Composable
fun CarListScreen(
    userList: List<Car>,
    onUserClick: (Car) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(
            items = userList,
            key = { it.id }
        ) { user ->
            CarCard(user, onUserClick)
        }
    }
}


@Composable
fun CarCard(
    userProfile: Car,
    onClick: (Car) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Colors.White,
            contentColor = Colors.AppBlue
        ),
        onClick = { onClick(userProfile) }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CarPicture(userProfile, 70.dp)
            CarContent(userProfile, Alignment.Start)
        }
    }
}

@Composable
fun CarPicture(
    userProfile: Car,
    profilePicSize: Dp
) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 1.dp,
            color = if (userProfile.isConnected)
                MaterialTheme.colorScheme.primary
            else
                MaterialTheme.colorScheme.error
        ),
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(userProfile.pictureUrl),
            contentDescription = "Photo de profil de ${userProfile.brand}",
            modifier = Modifier.size(profilePicSize),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun CarContent(
    car: Car,
    alignment: Alignment.Horizontal
) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = alignment
    ) {
        InlineTextContent(text = car.brand)
        InlineTextContent(text = car.model)
        InlineTextContent(text = car.category)
        InlineTextContent(text = car.licensePlate)

        Text(
            text = if (car.isConnected) "● Active now" else "● Offline",
            style = MaterialTheme.typography.bodyMedium,
            color = if (car.isConnected)
                MaterialTheme.colorScheme.primary
            else
                MaterialTheme.colorScheme.outline
        )
    }
}


@Preview()
@Composable
fun CardPreview(){
    CarListScreen(
        userList = userList,
        onUserClick = {}
    )
}