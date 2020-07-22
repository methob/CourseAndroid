package com.br.teste_catho.data.local.source

import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.data.remote.entity.Tips

interface HomeLocalDataSource {

    suspend fun getSuggestions(): MutableList<Suggestion>? = null
    suspend fun getTips(): MutableList<Tips>?

    suspend fun saveSuggestions(suggestion: MutableList<Suggestion>)
    suspend fun saveTips(tips: MutableList<Tips>)
}