package com.br.teste_catho.data.local.source

import com.br.teste_catho.data.local.db.HomeDao
import com.br.teste_catho.data.local.mapper.convertToListSuggestionsModel
import com.br.teste_catho.data.local.mapper.convertToListSuggestionsTb
import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.data.remote.entity.Tips

class HomeLocalDataSourceImpl(private val homeDao: HomeDao) : HomeLocalDataSource {

    override suspend fun getSuggestions(): MutableList<Suggestion> = homeDao.retrieveSuggestions()
        .convertToListSuggestionsModel()

    override suspend fun getTips(): MutableList<Tips> {
        TODO("Not yet implemented")
    }

    override suspend fun saveSuggestions(suggestion: MutableList<Suggestion>) = homeDao
        .saveSuggestions(suggestion.convertToListSuggestionsTb())

    override suspend fun saveTips(tips: MutableList<Tips>) {
        TODO("Not yet implemented")
    }

}