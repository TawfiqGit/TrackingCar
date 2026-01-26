package com.tawfiqdev.model

data class VehicleAccess(
    val accessId: String,
    val rentalId: String,
    val unlockToken: String,
    val isUsed: Boolean,
    val createdAt: Long
)