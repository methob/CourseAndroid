package com.br.teste_catho.model

sealed class ViewStatus<T>

class Loading<T>(val showLoading: Boolean): ViewStatus<T>()
class Success<T>(val response: T): ViewStatus<T>()
class Failed<T>(val response: ViewError): ViewStatus<T>()
