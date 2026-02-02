package com.tawfiqdev.model

data class Car(
    val carId: Int,
    val brand: String,
    val model: String,
    val category: String,
    val licensePlate: String,
    val isConnected: Boolean,
    val latitude: Double,
    val longitude: Double,
    val status: CarStatus
)

enum class CarStatus {
    AVAILABLE,
    RESERVED,
    IN_USE,
    MAINTENANCE
}