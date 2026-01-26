package com.tawfiqdev.model

data class Rental(
    val rentalId: String,
    val reservationId: String,
    val checkInDate: Long,
    val checkOutDate: Long? = null,
    val startMileage: Int,
    val endMileage: Int? = null,
    val status: RentalStatus
)

enum class RentalStatus {
    ACTIVE,
    FINISHED
}