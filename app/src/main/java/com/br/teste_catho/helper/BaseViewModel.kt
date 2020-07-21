package com.br.teste_catho.helper

import androidx.lifecycle.ViewModel
import com.br.teste_catho.model.ViewError
import kotlinx.coroutines.Dispatchers

open class BaseViewModel: ViewModel() {

    val backgroundContext = Dispatchers.IO
    val mainContext = Dispatchers.Main

    class CallError {
        private var remoteApiError : ((api: ViewError) -> Unit)? = null
        private var genericError : ((error: ViewError) -> Unit)? = null

//        operator fun invoke(api: RemoteError) { remoteApiError?.invoke(api) }
        operator fun invoke(error: ViewError) {
                         genericError?.invoke(error)
                         remoteApiError?.invoke(error)
            }

        fun onHttpErrorCall(block: (api: ViewError) -> Unit) { remoteApiError = block }
//        fun onGenericErrorCall(block: (error: ViewError) -> Unit) { genericError = block }
    }
}