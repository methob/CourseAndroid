package com.br.teste_catho.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.br.teste_catho.domain.usecase.GetSuggestionsUseCase
import com.br.teste_catho.helper.BaseViewModel
import com.br.teste_catho.helper.handleHttpError
import com.br.teste_catho.model.ViewStatus
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(private val getSuggestionsUseCase: GetSuggestionsUseCase) : BaseViewModel() {

    var liveDataResponse: MutableLiveData<ViewStatus> = MutableLiveData()

    fun getSuggestion() = viewModelScope.launch(backgroundContext) {
        getSuggestionsUseCase.homeRepository.getSuggestion()
            .handleHttpError { onHttpErrorCall { liveDataResponse.postValue(ViewStatus.Error(it))} }
            .collect { liveDataResponse.postValue(ViewStatus.Success(it)) }
    }
}