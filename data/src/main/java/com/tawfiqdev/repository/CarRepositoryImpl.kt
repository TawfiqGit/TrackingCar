package com.tawfiqdev.repository

import com.tawfiqdev.database.dao.CarDao
import com.tawfiqdev.mapper.toDomain
import com.tawfiqdev.model.Vehicle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val carDao: CarDao
) : CarRepository {

    override fun observeAllVehicle(): Flow<List<Vehicle>> {
       return carDao.observeVehicles().map { it -> it.map { it.toDomain() } }
    }
}