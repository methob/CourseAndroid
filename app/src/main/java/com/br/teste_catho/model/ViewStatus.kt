package com.br.teste_catho.model

sealed class ViewStatus {
    object Loading: ViewStatus()
    class Success<T>(response: T): ViewStatus()
    class Error(response: ViewError): ViewStatus()
}