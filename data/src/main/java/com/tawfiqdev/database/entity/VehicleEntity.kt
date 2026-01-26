package com.tawfiqdev.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicles")
data class VehicleEntity(
    @PrimaryKey val vehicleId: String,
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