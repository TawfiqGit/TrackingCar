package com.tawfiqdev.mapper

import com.tawfiqdev.database.entity.ReservationEntity
import com.tawfiqdev.model.Reservation

fun ReservationEntity.toDomain(): Reservation = Reservation(
    reservationId = reservationId,
    userId = userId,
    vehicleId = vehicleId,
    startDate = startDate,
    endDate = endDate,
    status = com.tawfiqdev.model.ReservationStatus.CREATED
)

fun Reservation.toEntity(): ReservationEntity = ReservationEntity(
    reservationId = reservationId,
    userId = userId,
    vehicleId = vehicleId,
    startDate = startDate,
    endDate = endDate,
    status = com.tawfiqdev.database.entity.ReservationStatus.CREATED
)