package com.tawfiqdev.mapper

import com.tawfiqdev.database.entity.VehicleAccessEntity
import com.tawfiqdev.model.VehicleAccess

fun VehicleAccessEntity.toDomain(): VehicleAccess = VehicleAccess(
    accessId = accessId,
    rentalId = rentalId,
    unlockToken = unlockToken,
    isUsed = isUsed,
    createdAt = createdAt,
)

fun VehicleAccess.toEntity(): VehicleAccessEntity = VehicleAccessEntity(
    accessId = accessId,
    rentalId = rentalId,
    unlockToken = unlockToken,
    isUsed = isUsed,
    createdAt = createdAt,
)