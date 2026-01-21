package com.tawfiqdev.mapper

import com.tawfiqdev.database.entity.UserEntity
import com.tawfiqdev.model.User

fun UserEntity.toDomain(): User = User(
    userId = userId,
    firstName = firstName,
    lastName = lastName,
    email = email,
    phone = phone
)

fun User.toEntity(): UserEntity = UserEntity(
    userId = userId,
    firstName = firstName,
    lastName = lastName,
    email = email,
    phone = phone
)