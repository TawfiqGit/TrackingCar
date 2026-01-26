package com.tawfiqdev.model

data class User (
    val userId: Long = 0,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String
)