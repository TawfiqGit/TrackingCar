package com.tawfiqdev.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "rentals",
    foreignKeys = [
        ForeignKey(
            entity = ReservationEntity::class,
            parentColumns = ["reservationId"],
            childColumns = ["reservationId"]
        )
    ]
)
data class RentalEntity(
    @PrimaryKey val rentalId: String,
    val reservationId: String,
    val checkInDate: Long,
    val checkOutDate: Long? = null,
    val startMileage: Int,
    val endMileage: Int? = null,
    val status: RentalStatus = RentalStatus.ACTIVE,
)

enum class RentalStatus {
    ACTIVE,
    FINISHED
}