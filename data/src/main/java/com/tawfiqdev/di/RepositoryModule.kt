package com.tawfiqdev.di

import com.tawfiqdev.repository.UserRepository
import com.tawfiqdev.repository.UserRepositoryImpl
import com.tawfiqdev.repository.VehicleModelRepository
import com.tawfiqdev.repository.VehicleModelRepositoryImpl
import com.tawfiqdev.repository.VehicleRepository
import com.tawfiqdev.repository.VehicleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindVehicleRepository(impl: VehicleRepositoryImpl): VehicleRepository

    @Binds
    @Singleton
    abstract fun bindVehicleModelRepository(impl: VehicleModelRepositoryImpl): VehicleModelRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
}