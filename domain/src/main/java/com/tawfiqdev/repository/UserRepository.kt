package com.tawfiqdev.repository

import com.tawfiqdev.model.User

interface UserRepository {
    suspend fun insert(user: User) : Boolean
    suspend fun update(user: User) : Boolean
    suspend fun delete(user: User): Boolean
    suspend fun getUserByEmail(email: String): User
}
