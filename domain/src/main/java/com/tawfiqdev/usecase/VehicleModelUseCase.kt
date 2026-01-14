package com.tawfiqdev.usecase

import com.tawfiqdev.model.VehicleModel
import com.tawfiqdev.repository.VehicleModelRepository
import com.tawfiqdev.utils.ErrorState
import com.tawfiqdev.utils.ResultOutput
import kotlinx.coroutines.flow.Flow

class FlowAllVehicleModelUseCase (private val repository: VehicleModelRepository){
    operator fun invoke(): Flow<List<VehicleModel>> = repository.observeAll()
}

class SeedVehicleModelIfEmptyUseCase(private val repo: VehicleModelRepository) {
    suspend operator fun invoke() : ResultOutput<Int, ErrorState> = repo.seedIfEmpty()
}