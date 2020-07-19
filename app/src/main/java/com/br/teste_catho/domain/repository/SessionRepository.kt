package com.br.teste_catho.domain.repository

import com.br.teste_catho.data.remote.entity.Keys
import com.br.teste_catho.data.remote.entity.User
import kotlinx.coroutines.flow.Flow

interface SessionRepository {
    suspend fun getKeys(): Flow<Keys>
    suspend fun getUser(): Flow<User>
}