package com.br.teste_catho.helper

import androidx.lifecycle.ViewModel
import com.br.teste_catho.model.ViewError
import kotlinx.coroutines.Dispatchers

open class BaseViewModel: ViewModel() {

    val backgroundContext = Dispatchers.IO
    val mainContext = Dispatchers.Main

}