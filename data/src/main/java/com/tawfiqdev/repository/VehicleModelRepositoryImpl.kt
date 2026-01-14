package com.tawfiqdev.repository

import com.tawfiqdev.database.dao.VehicleModelDao
import com.tawfiqdev.database.entity.VehicleModelEntity
import com.tawfiqdev.mapper.toDomain
import com.tawfiqdev.model.VehicleModel
import com.tawfiqdev.utils.ErrorState
import com.tawfiqdev.utils.ResultOutput
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VehicleModelRepositoryImpl @Inject constructor(
    private val vehicleModelDao: VehicleModelDao,
): VehicleModelRepository {

    override fun observeAll(): Flow<List<VehicleModel>> = vehicleModelDao.observeAll().map { list ->
        list.map { e -> e.toDomain() }
    }

    override suspend fun seedIfEmpty(): ResultOutput<Int, ErrorState> =
        try {
            val count = vehicleModelDao.count()
            if (count == 0) {
                val seed = listOf(
                    VehicleModelEntity(marque = "Renault", brand = "Rafale", version = "E-Tech 4x4 300 Atelier Alpine", year = 2024, energy = "Hybride essence électrique", lengthMeters = 4.71, widthMeters = 1.87, heightMeters = 1.61, wheelbaseMeters = 2.74, weightVadFinKg = 2009, color = "Bleu Alpine"),
                    VehicleModelEntity(marque = "Tesla", brand = "Model 3", version = "Propulsion", year = 2024, energy = "Électrique", lengthMeters = 4.72, widthMeters = 1.85, heightMeters = 1.44, wheelbaseMeters = 2.88, weightVadFinKg = 1830, color = "Blanc Nacré"),
                    VehicleModelEntity(marque = "Peugeot", brand = "208", version = "PureTech 100 Allure", year = 2023, energy = "Essence", lengthMeters = 4.06, widthMeters = 1.75, heightMeters = 1.43, wheelbaseMeters = 2.54, weightVadFinKg = 1090, color = "Jaune Faro"),
                    VehicleModelEntity(marque = "BMW", brand = "X5", version = "xDrive50e M Sport", year = 2024, energy = "Hybride rechargeable essence", lengthMeters = 4.92, widthMeters = 2.00, heightMeters = 1.75, wheelbaseMeters = 2.97, weightVadFinKg = 2510, color = "Noir Carbone métallisé"),
                    VehicleModelEntity(marque = "Dacia", brand = "Spring", version = "Extreme 65 ch", year = 2024, energy = "Électrique", lengthMeters = 3.73, widthMeters = 1.58, heightMeters = 1.52, wheelbaseMeters = 2.42, weightVadFinKg = 970, color = "Vert Cèdre")
                )
                vehicleModelDao.insertAll(seed)
                ResultOutput.Success(seed.size)
            }else {
                ResultOutput.Success(0)
            }
        }catch (e: Exception){
            ResultOutput.Failure(ErrorState.Database(e))
        }
}