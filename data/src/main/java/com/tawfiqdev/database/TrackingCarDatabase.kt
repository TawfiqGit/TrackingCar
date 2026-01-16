package com.tawfiqdev.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tawfiqdev.database.dao.UserDao
import com.tawfiqdev.database.entity.LoginEntity
import com.tawfiqdev.database.entity.PasswordEntity

@Database(
    entities = [
        LoginEntity::class,
        PasswordEntity::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class TrackingCarDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}