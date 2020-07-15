package com.br.teste_catho.data.repositories

import com.br.teste_catho.data.local.source.SessionLocalDataSource
import com.br.teste_catho.data.remote.entity.Keys
import com.br.teste_catho.data.remote.entity.User
import com.br.teste_catho.data.remote.source.SessionRemoteDataSource
import com.br.teste_catho.domain.repository.SessionRepository
import kotlinx.coroutines.flow.Flow

class SessionRepositoryImpl(private val sessionLocalDataSource: SessionLocalDataSource,
                            private val sessionRemoteDataSource: SessionRemoteDataSource)
    : SessionRepository {

    override fun getKeys(): Flow<Keys> {
        TODO("Not yet implemented")
    }

    override fun getUser(): Flow<User> {
        TODO("Not yet implemented")
    }

}