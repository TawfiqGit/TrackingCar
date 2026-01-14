package com.tawfiqdev.mapper

fun EntryExitLogEntity.toDomain() = EntryExitLog(
    id = id,
    reservationId = reservationId,
    entryTime = entryTime,
    exitTime = exitTime,
    gateName = gateName
)

fun EntryExitLog.toEntity() = EntryExitLogEntity(
    id = id,
    reservationId = reservationId,
    entryTime = entryTime,
    exitTime = exitTime,
    gateName = gateName
)