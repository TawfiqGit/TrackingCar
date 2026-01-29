package com.tawfiqdev.mapper

import com.tawfiqdev.database.entity.CarEntity
import com.tawfiqdev.model.Vehicle
import com.tawfiqdev.model.CarStatus

fun CarEntity.toDomain(): Vehicle = Vehicle(
    vehicleId = id,
    brand = brand,
    model = model,
    category = category,
    licensePlate = licensePlate,
    isConnected = isConnected,
    latitude = latitude,
    longitude = longitude,
    status = CarStatus.AVAILABLE
)

fun Vehicle.toEntity(): CarEntity = CarEntity(
    id = vehicleId,
    brand = brand,
    model = model,
    category = category,
    licensePlate = licensePlate,
    isConnected = isConnected,
    latitude = latitude,
    longitude = longitude,
    status = com.tawfiqdev.database.entity.CarStatus.AVAILABLE
)