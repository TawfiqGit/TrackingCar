package com.tawfiqdev.mapper

fun PaymentEntity.toDomain() = Payment(
    id = id,
    providerRef = providerRef,
    reservationId = reservationId,
    createdAt = createdAt,
    amount = amount,
    method = method,
    status = status,
    currency = currency
)

fun Payment.toEntity() = PaymentEntity(
    id = id,
    providerRef = providerRef,
    reservationId = reservationId,
    createdAt = createdAt,
    amount = amount,
    method = method,
    status = status,
    currency = currency
)
