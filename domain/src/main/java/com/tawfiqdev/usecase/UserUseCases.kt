package com.tawfiqdev.usecase

import com.tawfiqdev.model.User
import com.tawfiqdev.repository.UserRepository
import kotlin.text.isBlank

class GetUserByEmailUseCase (private val repository: UserRepository){
    suspend operator fun invoke(email : String): User = repository.getUserByEmail(email = email)
}

class InsertUserUseCase (private val repository: UserRepository) {
    suspend operator fun invoke(input: User): Boolean  {
        if (input.email.isBlank()){
            return false
        }
        return repository.insert(input.copy(email = input.email))
    }
}

class UpdateUserUseCase (private val repository: UserRepository) {
    suspend operator fun invoke(user: User): Boolean {
        if (user.email.isBlank() || user.email.isEmpty() ){
            return false
        }
        return repository.update(user)
    }
}

class DeleteUserUseCase (private val repository: UserRepository) {
    suspend operator fun invoke(user: User): Boolean {
        if (user.email.isBlank() || user.email.isEmpty() ){
            return false
        }
        return repository.delete(user)
    }
}

