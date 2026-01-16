package com.tawfiqdev.mapper

import com.tawfiqdev.database.entity.DataLoginEntity
import com.tawfiqdev.database.entity.DataPasswordEntity
import com.tawfiqdev.database.entity.LoginEntity
import com.tawfiqdev.database.entity.PasswordEntity
import com.tawfiqdev.model.DataLogin
import com.tawfiqdev.model.DataPassword
import com.tawfiqdev.model.Login
import com.tawfiqdev.model.Password

fun LoginEntity.toDomain(): Login = Login(
    api_vesrion = api_vesrion,
    data = data.toDomain(),
)

fun DataLoginEntity.toDomain(): DataLogin = DataLogin(
    id = id,
    token = token,
    userName = userName,
    givenName = givenName,
)

fun PasswordEntity.toDomain(): Password = Password(
    api_vesrion = api_vesrion,
    data = data.toDomain(),
)

fun DataPasswordEntity.toDomain(): DataPassword = DataPassword(
    token = token,
    jti = jti
)