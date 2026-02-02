package com.tawfiqdev.mapper

import com.tawfiqdev.database.entity.CarEntity
import com.tawfiqdev.model.Car
import com.tawfiqdev.model.CarStatus

fun CarEntity.toDomain(): Car = Car(
    carId = carId,
    brand = brand,
    model = model,
    category = category,
    licensePlate = licensePlate,
    isConnected = isConnected,
    latitude = latitude,
    longitude = longitude,
    status = CarStatus.AVAILABLE
)

fun Car.toEntity(): CarEntity = CarEntity(
    carId = carId,
    brand = brand,
    model = model,
    category = category,
    licensePlate = licensePlate,
    isConnected = isConnected,
    latitude = latitude,
    longitude = longitude,
    status = com.tawfiqdev.database.entity.CarStatus.AVAILABLE
)