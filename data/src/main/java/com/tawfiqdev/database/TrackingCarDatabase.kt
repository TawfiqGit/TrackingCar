package com.tawfiqdev.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tawfiqdev.database.dao.UserDao
import com.tawfiqdev.database.dao.VehicleDao
import com.tawfiqdev.database.dao.VehicleModelDao
import com.tawfiqdev.database.entity.UserEntity
import com.tawfiqdev.database.entity.VehicleEntity
import com.tawfiqdev.database.entity.VehicleModelEntity

@Database(
    entities = [
        UserEntity::class,
        VehicleEntity::class,
        VehicleModelEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class TrackingCarDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
    abstract fun vehicleModelDao(): VehicleModelDao
    abstract fun userDao(): UserDao
}