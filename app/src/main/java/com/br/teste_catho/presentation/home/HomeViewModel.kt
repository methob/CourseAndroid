package com.br.teste_catho.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.domain.usecase.GetSuggestionsUseCase
import com.br.teste_catho.helper.BaseViewModel
import com.br.teste_catho.helper.handleHttpError
import com.br.teste_catho.model.Failed
import com.br.teste_catho.model.Success
import com.br.teste_catho.model.ViewStatus
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(private val getSuggestionsUseCase: GetSuggestionsUseCase) : BaseViewModel() {

    var liveDataResponse: MutableLiveData<ViewStatus<MutableList<Suggestion>>> = MutableLiveData()

    fun getSuggestion() = viewModelScope.launch(backgroundContext) {
        getSuggestionsUseCase.homeRepository.getSuggestion()
            .handleHttpError { onHttpErrorCall { error -> liveDataResponse.postValue(Failed(error))} }
            .collect { liveDataResponse.postValue(Success(it)) }
    }
}


