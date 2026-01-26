package com.tawfiqdev.mapper

import com.tawfiqdev.database.entity.RentalEntity
import com.tawfiqdev.model.Rental

fun RentalEntity.toDomain(): Rental = Rental(
    rentalId = rentalId,
    reservationId = reservationId,
    checkInDate = checkInDate,
    checkOutDate = checkOutDate,
    startMileage = startMileage,
    endMileage = endMileage,
    status = com.tawfiqdev.model.RentalStatus.ACTIVE
)

fun Rental.toEntity(): RentalEntity = RentalEntity(
    rentalId = rentalId,
    reservationId = reservationId,
    checkInDate = checkInDate,
    checkOutDate = checkOutDate,
    startMileage = startMileage,
    endMileage = endMileage,
    status = com.tawfiqdev.database.entity.RentalStatus.ACTIVE
)