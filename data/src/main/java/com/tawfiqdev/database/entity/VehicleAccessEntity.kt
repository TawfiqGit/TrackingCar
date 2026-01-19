package com.tawfiqdev.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "vehicle_access",
    foreignKeys = [
        ForeignKey(
            entity = RentalEntity::class,
            parentColumns = ["rentalId"],
            childColumns = ["rentalId"]
        )
    ]
)
data class VehicleAccessEntity(
    @PrimaryKey val accessId: String,
    val rentalId: String,
    val unlockToken: String,
    val isUsed: Boolean,
    val createdAt: Long
)