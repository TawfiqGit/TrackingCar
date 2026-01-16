package com.tawfiqdev.di

import com.tawfiqdev.repository.UserRepository
import com.tawfiqdev.usecase.ObserveLoginUseCase
import com.tawfiqdev.usecase.ObservePasswordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    /**--UserRepository--**/
    @Provides
    fun provideLoginUseCase(
        repo: UserRepository
    ) = ObserveLoginUseCase(repo)

    @Provides
    fun providePasswordUseCase(
        repo: UserRepository
    ) = ObservePasswordUseCase(repo)
}