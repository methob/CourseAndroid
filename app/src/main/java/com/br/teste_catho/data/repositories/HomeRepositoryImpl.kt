package com.br.teste_catho.data.repositories

import com.br.teste_catho.data.local.source.HomeLocalDataSource
import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.data.remote.entity.Tips
import com.br.teste_catho.data.remote.source.HomeRemoteDataSource
import com.br.teste_catho.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class HomeRepositoryImpl(private val homeRemoteDataSource: HomeRemoteDataSource,
                         private val homeLocalDataSource: HomeLocalDataSource): HomeRepository {

    override suspend fun getSuggestion(): Flow<Suggestion> {
        TODO("Not yet implemented")
    }

    override suspend fun getTips(): Flow<Tips> {
        TODO("Not yet implemented")
    }

}