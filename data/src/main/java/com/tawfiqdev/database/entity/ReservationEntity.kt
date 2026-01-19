package com.tawfiqdev.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "reservations",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["userId"],
            childColumns = ["userId"]
        ),
        ForeignKey(
            entity = VehicleEntity::class,
            parentColumns = ["vehicleId"],
            childColumns = ["vehicleId"]
        )
    ]
)

data class ReservationEntity(
    @PrimaryKey val reservationId: String,
    val userId: String,
    val vehicleId: String,
    val startDate: Long,
    val endDate: Long,
    val status: ReservationStatus
)

enum class ReservationStatus {
    CREATED,
    CONFIRMED,
    CANCELLED,
    COMPLETED
}