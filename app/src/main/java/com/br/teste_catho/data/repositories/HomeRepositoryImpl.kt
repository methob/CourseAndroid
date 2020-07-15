package com.br.teste_catho.data.repositories

import com.br.teste_catho.data.local.source.HomeLocalDataSource
import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.data.remote.entity.Tips
import com.br.teste_catho.data.remote.source.HomeRemoteDataSource
import com.br.teste_catho.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class HomeRepositoryImpl(private val homeRemoteDataSource: HomeRemoteDataSource,
                         private val homeLocalDataSource: HomeLocalDataSource): HomeRepository {

    override fun getSuggestion(): Flow<Suggestion> {
        TODO("Not yet implemented")
    }

    override fun getTips(): Flow<Tips> {
        TODO("Not yet implemented")
    }

}