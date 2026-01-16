package com.tawfiqdev.repository

import com.tawfiqdev.database.dao.UserDao
import com.tawfiqdev.mapper.toDomain
import com.tawfiqdev.mapper.toEntity
import com.tawfiqdev.model.User
import com.tawfiqdev.utils.ErrorState
import com.tawfiqdev.utils.ResultOutput
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {

    override suspend fun login(identifier: String): String {
        try {
            val entity = userDao.getById(identifier)
        } catch (e: Exception) {
            ResultOutput.Failure(ErrorState.Database(e))
        }
    }

    override suspend fun password(password: String): ResultOutput<User?, ErrorState> {
        TODO("Not yet implemented")
    }
}