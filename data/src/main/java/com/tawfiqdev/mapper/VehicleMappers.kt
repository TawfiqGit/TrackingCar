package com.tawfiqdev.mapper

import com.tawfiqdev.model.Vehicle
import com.tawfiqdev.database.entity.VehicleEntity

fun VehicleEntity.toDomain(): Vehicle = Vehicle(
    id = id,
    userId = userId,
    registrationPlate = registrationPlate,
    vehicleModel = vehicleModel
)

fun Vehicle.toEntity(): VehicleEntity = VehicleEntity(
    id = id,
    userId = userId,
    registrationPlate = registrationPlate,
    vehicleModel = vehicleModel,
)