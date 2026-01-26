package com.tawfiqdev.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "vehicle_checks",
    foreignKeys = [
        ForeignKey(
            entity = RentalEntity::class,
            parentColumns = ["rentalId"],
            childColumns = ["rentalId"]
        )
    ]
)
data class VehicleCheckEntity(
    @PrimaryKey val checkId: String,
    val rentalId: String,
    val type: CheckType, // IN / OUT
    val mileage: Int,
    val comment: String?,
    val createdAt: Long
)

enum class CheckType {
    CHECK_IN,
    CHECK_OUT
}