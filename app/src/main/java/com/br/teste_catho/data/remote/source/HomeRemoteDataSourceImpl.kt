package com.br.teste_catho.data.remote.source

import com.br.teste_catho.data.remote.AppApi
import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.data.remote.entity.Tips

class HomeRemoteDataSourceImpl(private val appApi: AppApi) : HomeRemoteDataSource {

    override suspend fun getSuggestions(): MutableList<Suggestion> = appApi.getSuggestions()

    override suspend fun getTips(): MutableList<Tips> = appApi.getTips()

}