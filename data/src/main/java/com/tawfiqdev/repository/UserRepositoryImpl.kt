package com.tawfiqdev.repository

import com.tawfiqdev.database.dao.UserDao
import com.tawfiqdev.mapper.toDomain
import com.tawfiqdev.mapper.toEntity
import com.tawfiqdev.model.User
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {

    override suspend fun insert(user: User): Boolean {
        userDao.insert(user.toEntity())
        return true
    }

    override suspend fun update(user: User): Boolean {
        userDao.update(user.toEntity())
        return true
    }

    override suspend fun delete(user: User): Boolean {
        userDao.delete(user.toEntity())
        return true
    }

    override suspend fun getUserByEmail(email: String): User {
        return userDao.getUserByEmail(email).toDomain()
    }
}