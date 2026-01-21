package com.tawfiqdev.model

data class Reservation(
    val reservationId: String,
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