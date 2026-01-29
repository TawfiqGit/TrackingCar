package com.tawfiqdev.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tawfiqdev.database.dao.RentalDao
import com.tawfiqdev.database.dao.ReservationDao
import com.tawfiqdev.database.dao.UserDao
import com.tawfiqdev.database.dao.VehicleAccessDao
import com.tawfiqdev.database.dao.VehicleCheckDao
import com.tawfiqdev.database.dao.CarDao
import com.tawfiqdev.database.entity.RentalEntity
import com.tawfiqdev.database.entity.ReservationEntity
import com.tawfiqdev.database.entity.UserEntity
import com.tawfiqdev.database.entity.VehicleAccessEntity
import com.tawfiqdev.database.entity.VehicleCheckEntity
import com.tawfiqdev.database.entity.CarEntity

@Database(
    entities = [
        UserEntity::class,
        ReservationEntity::class,
        RentalEntity::class,
        CarEntity::class,
        VehicleAccessEntity::class,
        VehicleCheckEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class TrackingCarDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun carDao(): CarDao
    abstract fun reservationDao(): ReservationDao
    abstract fun rentalDao(): RentalDao
    abstract fun vehicleAccessDao(): VehicleAccessDao
    abstract fun vehicleCheckDao(): VehicleCheckDao
}