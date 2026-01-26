package com.tawfiqdev.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tawfiqdev.database.entity.VehicleEntity
import com.tawfiqdev.database.entity.VehicleStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVehicles(vehicles: List<VehicleEntity>)

    @Query("""
        SELECT * FROM vehicles 
        WHERE status = 'AVAILABLE'
    """)
    fun getAvailableVehicles(): Flow<List<VehicleEntity>>

    @Query("""
        SELECT * FROM vehicles 
        WHERE vehicleId = :vehicleId
        LIMIT 1
    """)
    suspend fun getVehicleById(vehicleId: String): VehicleEntity?

    @Query("""
        UPDATE vehicles 
        SET status = :status 
        WHERE vehicleId = :vehicleId
    """)
    suspend fun updateVehicleStatus(
        vehicleId: String,
        status: VehicleStatus
    )

    @Query("SELECT * FROM vehicles")
    fun observeVehicles(): Flow<List<VehicleEntity>>
}