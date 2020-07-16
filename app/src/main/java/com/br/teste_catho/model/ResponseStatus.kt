package com.br.teste_catho.model

sealed class ResponseStatus<T>

class Success<T>(response: T): ResponseStatus<T>()
class Failed<T>(response: FailedStatus): ResponseStatus<T>()
