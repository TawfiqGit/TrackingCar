package com.tawfiqdev.mapper

import com.tawfiqdev.database.entity.VehicleEntity
import com.tawfiqdev.model.Vehicle

fun VehicleEntity.toDomain(): Vehicle = Vehicle(
    vehicleId = vehicleId,
    brand = brand,
    model = model,
    category = category,
    licensePlate = licensePlate,
    isConnected = isConnected,
    latitude = latitude,
    longitude = longitude,
    status = com.tawfiqdev.model.VehicleStatus.AVAILABLE
)

fun Vehicle.toEntity(): VehicleEntity = VehicleEntity(
    vehicleId = vehicleId,
    brand = brand,
    model = model,
    category = category,
    licensePlate = licensePlate,
    isConnected = isConnected,
    latitude = latitude,
    longitude = longitude,
    status = com.tawfiqdev.database.entity.VehicleStatus.AVAILABLE
)