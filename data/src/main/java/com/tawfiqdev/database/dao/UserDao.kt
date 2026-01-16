package com.tawfiqdev.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.tawfiqdev.model.Login
import com.tawfiqdev.model.Password

@Dao
interface UserDao {

    @Query("SELECT * FROM login")
    suspend fun getLogin(identifier : String): Login


    @Query("SELECT * FROM password")
    suspend fun getPassword(password: String): Password
}