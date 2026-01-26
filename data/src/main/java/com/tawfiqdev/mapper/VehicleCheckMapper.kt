package com.tawfiqdev.mapper

import com.tawfiqdev.database.entity.VehicleCheckEntity
import com.tawfiqdev.model.VehicleCheck

fun VehicleCheckEntity.toDomain(): VehicleCheck = VehicleCheck(
    checkId = checkId,
    rentalId = rentalId,
    type = com.tawfiqdev.model.CheckType.CHECK_IN,
    mileage = mileage,
    comment = comment,
    createdAt = createdAt,
)

fun VehicleCheck.toEntity(): VehicleCheckEntity = VehicleCheckEntity(
    checkId = checkId,
    rentalId = rentalId,
    type = com.tawfiqdev.database.entity.CheckType.CHECK_IN,
    mileage = mileage,
    comment = comment,
    createdAt = createdAt,
)