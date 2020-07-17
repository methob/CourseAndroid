package com.br.teste_catho.presentation.config

import androidx.lifecycle.ViewModel
import com.br.teste_catho.model.GenericError
import com.br.teste_catho.model.RemoteError
import kotlinx.coroutines.Dispatchers

open class BaseViewModel: ViewModel() {

    val backgroundContext = Dispatchers.IO
    val foregroundContext = Dispatchers.Main

    class CallError {
        private var remoteApiError : ((api: RemoteError) -> Unit)? = null
        private var genericError : ((error: GenericError) -> Unit)? = null

        operator fun invoke(api: RemoteError) { remoteApiError?.invoke(api) }
        operator fun invoke(error: GenericError) { genericError?.invoke(error) }

        fun onHttpErrorCall(block: (api: RemoteError) -> Unit) { remoteApiError = block }
        fun onGenericErrorCall(block: (error: GenericError) -> Unit) { genericError = block }
    }
}