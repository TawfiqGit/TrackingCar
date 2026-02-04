package com.tawfiqdev.usecase

import com.tawfiqdev.model.Car
import com.tawfiqdev.repository.CarRepository

class ListAllCarsUseCase (private val repository: CarRepository){
    suspend operator fun invoke(): List<Car> = repository.getListCars()
}
