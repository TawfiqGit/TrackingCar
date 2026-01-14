package com.tawfiqdev.mapper

fun ParkingEntity.toDomain(): Parking = Parking(
    id = id,
    name= name,
    category=category,
    pricePerHour=pricePerHour,
    rating=rating,
    distanceMins=distanceMins,
    spots=spots,
    imageRes= imageRes,
    imageUrl = imageUrl,
    address = address,
    reviewCount = reviewCount
)

fun Parking.toEntity(): ParkingEntity = ParkingEntity(
    id = id,
    name= name,
    category=category,
    pricePerHour=pricePerHour,
    rating=rating,
    distanceMins=distanceMins,
    spots=spots,
    imageRes= imageRes,
    imageUrl = imageUrl,
    address = address,
    reviewCount = reviewCount
)

fun ParkingSpotEntity.toDomain() = ParkingSpot(
    id = id,
    parkingId = parkingId,
    spotNumber = spotNumber,
    type = type,
    isActive = isActive
)