package com.tawfiqdev.usecase

import com.tawfiqdev.model.Vehicle
import com.tawfiqdev.repository.CarRepository
import kotlinx.coroutines.flow.Flow

class FlowAllVehicleUseCase (private val repository: CarRepository){
    operator fun invoke(): Flow<List<Vehicle>> = repository.observeAllVehicle()
}
