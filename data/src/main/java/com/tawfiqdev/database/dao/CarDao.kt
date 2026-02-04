package com.tawfiqdev.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tawfiqdev.database.entity.CarEntity
import com.tawfiqdev.database.entity.CarStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface CarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVehicles(vehicles: List<CarEntity>)

    @Query("""
        SELECT * FROM cars 
        WHERE status = 'AVAILABLE'
    """)
    fun getAvailableVehicles(): Flow<List<CarEntity>>

    @Query("""
        SELECT * FROM cars 
        WHERE carId = :carId
        LIMIT 1
    """)
    suspend fun getVehicleById(carId: String): CarEntity?

    @Query("""
        UPDATE cars 
        SET status = :status 
        WHERE carId = :carId
    """)
    suspend fun updateVehicleStatus(
        carId: String,
        status: CarStatus
    )

    @Query("SELECT * FROM cars")
    suspend fun getCars(): List<CarEntity>
}