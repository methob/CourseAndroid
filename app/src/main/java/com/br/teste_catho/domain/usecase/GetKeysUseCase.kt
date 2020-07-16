package com.br.teste_catho.domain.usecase

import com.br.teste_catho.data.remote.entity.Keys
import com.br.teste_catho.domain.repository.SessionRepository
import kotlinx.coroutines.flow.Flow

class GetKeysUseCase(
    private val sessionRepository: SessionRepository
) : BaseUseCase<Any, Flow<Keys>>() {
    override fun invoke(params: Any?): Flow<Keys> = sessionRepository.getKeys()
}