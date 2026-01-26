package com.tawfiqdev.model

data class Vehicle(
    val vehicleId: String,
    val brand: String,
    val model: String,
    val category: String,
    val licensePlate: String,
    val isConnected: Boolean,
    val latitude: Double,
    val longitude: Double,
    val status: VehicleStatus
)

enum class VehicleStatus {
    AVAILABLE,
    RESERVED,
    IN_USE,
    MAINTENANCE
}