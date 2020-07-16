package com.br.teste_catho.di

import com.br.teste_catho.domain.usecase.GetKeysUseCase
import org.koin.dsl.module.module

val useCases = module {
    single { GetKeysUseCase(get()) }
}