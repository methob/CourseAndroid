package com.br.teste_catho.domain.usecase

import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetSuggestionsUseCase(val homeRepository: HomeRepository): BaseUseCase<Any, Flow<MutableList<Suggestion>>>() {
    override suspend fun invoke(params: Any?): Flow<MutableList<Suggestion>> = homeRepository.getSuggestion()

}