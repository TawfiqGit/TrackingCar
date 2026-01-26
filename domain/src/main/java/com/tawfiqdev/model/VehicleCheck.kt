package com.tawfiqdev.model

data class VehicleCheck(
    val checkId: String,
    val rentalId: String,
    val type: CheckType, // IN / OUT
    val mileage: Int,
    val comment: String?,
    val createdAt: Long
)

enum class CheckType {
    CHECK_IN,
    CHECK_OUT
}