package com.tawfiqdev.di

import com.tawfiqdev.repository.UserRepository
import com.tawfiqdev.repository.VehicleModelRepository
import com.tawfiqdev.repository.VehicleRepository
import com.tawfiqdev.usecase.DeleteUserUseCase
import com.tawfiqdev.usecase.FlowAllVehicleModelUseCase
import com.tawfiqdev.usecase.FlowAllVehicleUseCase
import com.tawfiqdev.usecase.GetUserByIdUseCase
import com.tawfiqdev.usecase.GetVehicleByIdUseCase
import com.tawfiqdev.usecase.InsertUserUseCase
import com.tawfiqdev.usecase.InsertVehicleUseCase
import com.tawfiqdev.usecase.SeedVehicleModelIfEmptyUseCase
import com.tawfiqdev.usecase.UpdateUserUseCase
import com.tawfiqdev.usecase.UpdateVehicleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    /**--VehicleRepository--**/
    @Provides
    fun provideFlowAllVehicleUseCase(
        repo: VehicleRepository
    ) = FlowAllVehicleUseCase(repo)

    @Provides
    fun provideGetVehicleByIdUseCase(
        repo: VehicleRepository
    ) = GetVehicleByIdUseCase(repo)

    @Provides
    fun provideInsertVehicleUseCase(
        repo: VehicleRepository
    ) = InsertVehicleUseCase(repo)

    @Provides
    fun provideUpdateVehicleUseCase(
        repo: VehicleRepository
    ) = UpdateVehicleUseCase(repo)

    /**--VehicleModelRepository--**/

    @Provides
    fun provideFlowAllVehicleModelUseCase(
        repo: VehicleModelRepository
    ) = FlowAllVehicleModelUseCase(repo)

    @Provides
    fun provideInsertVehicleModelUseCase(
        repo: VehicleModelRepository
    ) = SeedVehicleModelIfEmptyUseCase(repo)

    /**--UserRepository--**/

    @Provides
    fun provideGetUserByIdUseCase(
        repo: UserRepository
    ) = GetUserByIdUseCase(repo)

    @Provides
    fun provideInsertUserUseCase(
        repo: UserRepository
    ) = InsertUserUseCase(repo)

    @Provides
    fun provideUpdateUserUseCase(
        repo: UserRepository
    ) = UpdateUserUseCase(repo)

    @Provides
    fun provideDeleteUserUseCase(
        repo: UserRepository
    ) = DeleteUserUseCase(repo)
}