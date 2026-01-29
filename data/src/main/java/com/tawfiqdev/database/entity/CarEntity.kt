package com.tawfiqdev.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
data class CarEntity(
    @PrimaryKey val id: String,
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