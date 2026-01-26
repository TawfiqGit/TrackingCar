package com.tawfiqdev.usecase

import com.tawfiqdev.model.Vehicle
import com.tawfiqdev.repository.VehicleRepository
import kotlinx.coroutines.flow.Flow

class FlowAllVehicleUseCase (private val repository: VehicleRepository){
    operator fun invoke(): Flow<List<Vehicle>> = repository.observeAllVehicle()
}
