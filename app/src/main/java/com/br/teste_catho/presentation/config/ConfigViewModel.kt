package com.br.teste_catho.presentation.config

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.br.teste_catho.domain.usecase.GetKeysUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ConfigViewModel(private val getKeysUseCase: GetKeysUseCase): BaseViewModel() {

    fun getSessionInfo() {
        viewModelScope.launch(backgroundContext + exceptionHandler) {
            getKeysUseCase().collect {
                Log.d(it.auth, "")
            }
        }
    }
}