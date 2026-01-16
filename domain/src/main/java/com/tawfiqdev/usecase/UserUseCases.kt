package com.tawfiqdev.usecase

import com.tawfiqdev.model.Login
import com.tawfiqdev.model.Password
import com.tawfiqdev.repository.UserRepository

class ObserveLoginUseCase (private val repository: UserRepository){
    suspend operator fun invoke(identifier: String): Login? = repository.login(identifier)
}

class ObservePasswordUseCase (private val repository: UserRepository){
    suspend operator fun invoke(password: String): Password? = repository.password(password)
}