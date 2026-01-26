package com.tawfiqdev.repository

import com.tawfiqdev.model.Vehicle
import kotlinx.coroutines.flow.Flow

interface VehicleRepository {
    fun observeAllVehicle(): Flow<List<Vehicle>>
}