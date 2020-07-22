package com.br.teste_catho.data.remote.source

import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.data.remote.entity.Tips

interface HomeRemoteDataSource {

    suspend fun getSuggestions(): MutableList<Suggestion>
    suspend fun getTips(): MutableList<Tips>
}