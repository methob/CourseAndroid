package com.br.teste_catho.presentation.config

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.br.teste_catho.data.remote.entity.User
import com.br.teste_catho.domain.usecase.GetKeysUseCase
import com.br.teste_catho.domain.usecase.GetUserUseCase
import com.br.teste_catho.helper.BaseViewModel
import com.br.teste_catho.helper.handleHttpError
import com.br.teste_catho.model.Failed
import com.br.teste_catho.model.Loading
import com.br.teste_catho.model.Success
import com.br.teste_catho.model.ViewStatus
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapConcat

class ConfigViewModel(private val getKeysUseCase: GetKeysUseCase,
                      private val getUserUseCase: GetUserUseCase): BaseViewModel() {

    var liveDataResponse: MutableLiveData<ViewStatus<User>> = MutableLiveData()

    fun getSessionInfo() = viewModelScope.launch(backgroundContext) {
        liveDataResponse.postValue(Loading(true))
        getKeysUseCase()
            .flatMapConcat { getUserUseCase() }
            .handleHttpError { onHttpErrorCall { liveDataResponse.postValue(Failed(it))} }
            .collect { liveDataResponse.postValue(Success(it))}
        }
}