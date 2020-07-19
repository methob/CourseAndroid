package com.br.teste_catho.domain.repository

import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.data.remote.entity.Tips
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getSuggestion(): Flow<Suggestion>
    suspend fun getTips(): Flow<Tips>
}