package com.br.teste_catho.presentation.config

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

open class BaseViewModel: ViewModel() {

    val backgroundContext = Dispatchers.IO
    val foregroundContext = Dispatchers.Main
    val exceptionHandler = CoroutineExceptionHandler {
            _: CoroutineContext, throwable: Throwable ->
            Log.d(throwable.message, "SHGUYAGSUAYGSUAGSUAYGSUAYSGUAY")
//        onResult(Error(throwable))
    }
}