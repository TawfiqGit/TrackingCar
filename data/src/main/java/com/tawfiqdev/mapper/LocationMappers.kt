package com.tawfiqdev.mapper

fun LocationEntity.toDomain() = LocationSelection(
    id = id,
    title = title,
    address = address,
    latitude = latitude,
    longitude = longitude
)