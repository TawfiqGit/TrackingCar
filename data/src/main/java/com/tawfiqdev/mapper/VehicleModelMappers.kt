package com.tawfiqdev.mapper

import com.tawfiqdev.database.entity.VehicleModelEntity
import com.tawfiqdev.model.VehicleModel

fun VehicleModelEntity.toDomain(): VehicleModel = VehicleModel(
    marque = marque,
    brand = brand,
    version = version,
    color = color,
    year = year,
    energy = energy,
    lengthMeters = lengthMeters,
    widthMeters = widthMeters,
    heightMeters = heightMeters,
    wheelbaseMeters = wheelbaseMeters,
    weightVadFinKg= weightVadFinKg,
)

fun VehicleModel.toEntity(): VehicleModelEntity = VehicleModelEntity(
    marque = marque,
    brand = brand,
    version = version,
    color = color,
    year = year,
    energy = energy,
    lengthMeters = lengthMeters,
    widthMeters = widthMeters,
    heightMeters = heightMeters,
    wheelbaseMeters = wheelbaseMeters,
    weightVadFinKg= weightVadFinKg,
)