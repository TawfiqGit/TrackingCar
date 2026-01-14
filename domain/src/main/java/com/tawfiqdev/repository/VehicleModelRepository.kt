package com.tawfiqdev.repository

import com.tawfiqdev.model.VehicleModel
import com.tawfiqdev.utils.ErrorState
import com.tawfiqdev.utils.ResultOutput
import kotlinx.coroutines.flow.Flow

interface VehicleModelRepository {
    fun observeAll(): Flow<List<VehicleModel>>
    suspend fun seedIfEmpty() : ResultOutput<Int, ErrorState>
}
