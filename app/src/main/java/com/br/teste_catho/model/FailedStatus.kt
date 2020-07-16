package com.br.teste_catho.model

sealed class FailedStatus

class ApiError<T>(response: T): FailedStatus()
object GenericError: FailedStatus()
object NetworkError: FailedStatus()