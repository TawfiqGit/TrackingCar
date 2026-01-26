package com.tawfiqdev.trackingcar.ui.cart

import kotlin.Int
import kotlin.String

data class Car(
    val id: Int,
    val brand: String,
    val model: String,
    val category: String,
    val licensePlate: String,
    val isConnected: Boolean,
    val latitude: Double,
    val longitude: Double,
    val status: Boolean,
    val pictureUrl: String
)

val userList = arrayListOf(
    Car(
        id = 0,
        brand = "Toyota" ,
        model = "Aygo X",
        category = "SUV" ,
        licensePlate = "KT-319-AD",
        isConnected = false,
        latitude = 88.6 ,
        longitude = 168.8,
        status = true,
        pictureUrl = "https://ix-marketing.imgix.net/auto-hero.png?auto=format,compress&w=3038"
    )
)