package com.br.teste_catho.di

import com.br.teste_catho.presentation.config.ConfigViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModels = module {

    viewModel { ConfigViewModel(get()) }
}
