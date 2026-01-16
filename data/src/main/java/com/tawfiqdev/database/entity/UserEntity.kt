package com.tawfiqdev.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "login")
data class LoginEntity (
    val api_vesrion: String,
    val data: DataLoginEntity,
)

data class DataLoginEntity (
    val id: String,
    val token: String,
    val userName: String,
    val givenName: String,
)

@Entity(tableName = "password")
data class PasswordEntity (
    val api_vesrion: String,
    val data: DataPasswordEntity,
)

data class DataPasswordEntity (
    val token: String,
    val jti: String,
)