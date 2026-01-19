package com.tawfiqdev.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.tawfiqdev.database.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE email = :email") suspend fun getUserByEmail(email: String): UserEntity
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insert(user: UserEntity)
    @Update suspend fun update(user: UserEntity)
    @Delete suspend fun delete(user: UserEntity)
}