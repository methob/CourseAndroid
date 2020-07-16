package com.br.teste_catho.domain.usecase

abstract class BaseUseCase<in PARAM, out RESPONSE> {
    abstract operator fun invoke(params: PARAM? = null): RESPONSE
}