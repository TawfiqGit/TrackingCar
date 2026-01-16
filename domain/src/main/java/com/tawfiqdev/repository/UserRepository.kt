package com.tawfiqdev.repository

import com.tawfiqdev.model.Login
import com.tawfiqdev.model.Password

interface UserRepository {
    suspend fun login(identifier: String): Login?
    suspend fun password(password: String): Password?
}
