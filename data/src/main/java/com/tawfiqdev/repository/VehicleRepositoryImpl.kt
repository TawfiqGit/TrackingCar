package com.tawfiqdev.repository

import com.tawfiqdev.database.dao.VehicleDao
import com.tawfiqdev.mapper.toDomain
import com.tawfiqdev.model.Vehicle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VehicleRepositoryImpl @Inject constructor(
    private val vehicleDao: VehicleDao
) : VehicleRepository {

    override fun observeAllVehicle(): Flow<List<Vehicle>> {
       return vehicleDao.observeVehicles().map { it -> it.map { it.toDomain() } }
    }
}