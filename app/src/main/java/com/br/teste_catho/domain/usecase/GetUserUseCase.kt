package com.br.teste_catho.domain.usecase

import com.br.teste_catho.data.remote.entity.User
import com.br.teste_catho.domain.repository.SessionRepository
import kotlinx.coroutines.flow.Flow

class GetUserUseCase(private val sessionRepository: SessionRepository): BaseUseCase<Any, Flow<User>>() {

    override suspend fun invoke(params: Any?): Flow<User> = sessionRepository.getUser()
}