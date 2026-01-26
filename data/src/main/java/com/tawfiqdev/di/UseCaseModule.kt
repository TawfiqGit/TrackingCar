package com.tawfiqdev.di

import com.tawfiqdev.repository.UserRepository
import com.tawfiqdev.usecase.DeleteUserUseCase
import com.tawfiqdev.usecase.GetUserByEmailUseCase
import com.tawfiqdev.usecase.InsertUserUseCase
import com.tawfiqdev.usecase.UpdateUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    /**--UserRepository--**/
    @Provides
    fun provideGetUserByIdUseCase(
        repo: UserRepository
    ) = GetUserByEmailUseCase(repo)

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