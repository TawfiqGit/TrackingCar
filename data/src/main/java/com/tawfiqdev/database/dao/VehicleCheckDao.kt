package com.tawfiqdev.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tawfiqdev.database.entity.CheckType
import com.tawfiqdev.database.entity.VehicleCheckEntity

@Dao
interface VehicleCheckDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCheck(check: VehicleCheckEntity)

    @Query("""
        SELECT * FROM vehicle_checks
        WHERE rentalId = :rentalId
        ORDER BY createdAt ASC
    """)
    suspend fun getChecksForRental(rentalId: String): List<VehicleCheckEntity>

    @Query("""
        SELECT * FROM vehicle_checks
        WHERE rentalId = :rentalId
          AND type = :type
        LIMIT 1
    """)
    suspend fun getCheckByType(
        rentalId: String,
        type: CheckType
    ): VehicleCheckEntity?
}