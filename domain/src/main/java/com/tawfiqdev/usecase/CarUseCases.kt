package com.tawfiqdev.usecase

import com.tawfiqdev.model.Car
import com.tawfiqdev.repository.CarRepository

class GetListCarsUseCase(private val repository: CarRepository) {
    suspend operator fun invoke(): List<Car> {
        return repository.getListCars()
    }
}

class InsertCarUseCase (private val repository: CarRepository){
    suspend operator fun invoke(input: Car) : Boolean {
        return repository.insert(input.copy())
    }
}