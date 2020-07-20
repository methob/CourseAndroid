package com.br.teste_catho.presentation.config

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.br.teste_catho.domain.usecase.GetKeysUseCase
import com.br.teste_catho.domain.usecase.GetUserUseCase
import com.br.teste_catho.helper.handleHttpError
import com.br.teste_catho.model.ViewStatus
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapConcat

class ConfigViewModel(private val getKeysUseCase: GetKeysUseCase,
                      private val getUserUseCase: GetUserUseCase): BaseViewModel() {

    var liveDataResponse: MutableLiveData<ViewStatus> = MutableLiveData()

    fun getSessionInfo() = viewModelScope.launch(backgroundContext) {
        liveDataResponse.postValue(ViewStatus.Loading)
        getKeysUseCase()
            .flatMapConcat { getUserUseCase() }
            .handleHttpError { onHttpErrorCall { liveDataResponse.postValue(ViewStatus.Error(it))}}
            .collect { liveDataResponse.postValue(ViewStatus.Success(it))}
        }
}