package com.tawfiqdev.repository

import com.tawfiqdev.model.Car

interface CarRepository {
    suspend fun getListCars(): List<Car>
    suspend fun insert(car: Car): Boolean
}