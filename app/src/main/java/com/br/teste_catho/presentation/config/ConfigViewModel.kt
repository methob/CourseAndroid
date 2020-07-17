package com.br.teste_catho.presentation.config

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.br.teste_catho.data.remote.entity.Keys
import com.br.teste_catho.domain.usecase.GetKeysUseCase
import com.br.teste_catho.helper.handleHttpError
import com.br.teste_catho.model.ViewStatus
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ConfigViewModel(private val getKeysUseCase: GetKeysUseCase): BaseViewModel() {

    var liveDataResponse: MutableLiveData<ViewStatus<Keys>> = MutableLiveData()

    @ExperimentalCoroutinesApi
    fun getSessionInfo() {
        viewModelScope.launch(backgroundContext) {
            getKeysUseCase()
                .handleHttpError {
                    onHttpErrorCall {
                        Log.d(it.message, it.status)
                    }
                    onGenericErrorCall {
                        Log.d("SAUJSAS", "JOISAJOIAJOISa")
                    }
                }
                .collect {
                    Log.d(it.auth, "")
                }
        }
    }
}