package com.tawfiqdev.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tawfiqdev.database.entity.VehicleModelEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleModelDao {
    @Insert
    suspend fun insert(vehicleModelEntity: VehicleModelEntity) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<VehicleModelEntity>)

    @Query("SELECT COUNT(*) FROM vehicles_model")
    suspend fun count(): Int

    @Query("SELECT * FROM vehicles_model")
    fun observeAll(): Flow<List<VehicleModelEntity>>
}