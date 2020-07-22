package com.br.teste_catho.data.repositories

import com.br.teste_catho.data.local.source.HomeLocalDataSource
import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.data.remote.entity.Tips
import com.br.teste_catho.data.remote.source.HomeRemoteDataSource
import com.br.teste_catho.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl(private val homeRemoteDataSource: HomeRemoteDataSource,
                         private val homeLocalDataSource: HomeLocalDataSource): HomeRepository {

    override suspend fun getSuggestion(): Flow<MutableList<Suggestion>> = flow {
        val suggestionDatabase = homeLocalDataSource.getSuggestions()
        if (suggestionDatabase.isNullOrEmpty()) {
            val suggestionRemote = homeRemoteDataSource.getSuggestions()
            homeLocalDataSource.saveSuggestions(suggestionRemote)
            emit(suggestionRemote)
        } else {
            emit(suggestionDatabase.apply {  })
        }
    }

    override suspend fun getTips(): Flow<MutableList<Tips>> {
        TODO("Not yet implemented")
    }

}