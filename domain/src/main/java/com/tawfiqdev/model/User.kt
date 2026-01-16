package com.tawfiqdev.model

data class Login (
    val api_vesrion: String,
    val data: DataLogin,
)

data class DataLogin (
    val id: String,
    val token: String,
    val userName: String,
    val givenName: String,
)

data class Password (
    val api_vesrion: String,
    val data: DataPassword,
)

data class DataPassword (
    val token: String,
    val jti: String,
)