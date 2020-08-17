package com.br.teste_catho.data.repositories

import com.br.teste_catho.data.local.source.SessionLocalDataSource
import com.br.teste_catho.data.remote.entity.Keys
import com.br.teste_catho.data.remote.entity.User
import com.br.teste_catho.data.remote.source.SessionRemoteDataSource
import com.br.teste_catho.domain.repository.SessionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SessionRepositoryImpl(private val sessionLocalDataSource: SessionLocalDataSource,
                            private val sessionRemoteDataSource: SessionRemoteDataSource)
    : SessionRepository {

    override suspend fun getKeys() = flow {
        val keys = sessionRemoteDataSource.getKeys()
        sessionLocalDataSource.saveKeys(keys)
        emit(keys)
    }

    override suspend fun getUser() = flow {
        val user = sessionRemoteDataSource.getUser()
        sessionLocalDataSource.saveUser(user)
        emit(user)
    }
}