package com.tawfiqdev.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tawfiqdev.database.entity.VehicleAccessEntity

@Dao
interface VehicleAccessDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccess(access: VehicleAccessEntity)

    @Query("""
        SELECT * FROM vehicle_access
        WHERE rentalId = :rentalId
        LIMIT 1
    """)
    suspend fun getAccessForRental(rentalId: String): VehicleAccessEntity?

    @Query("""
        UPDATE vehicle_access
        SET isUsed = 1
        WHERE accessId = :accessId
    """)
    suspend fun markAccessAsUsed(accessId: String)
}