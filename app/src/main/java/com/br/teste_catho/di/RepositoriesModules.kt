package com.br.teste_catho.di

import com.br.teste_catho.data.local.DatabaseConfiguration
import com.br.teste_catho.data.local.db.AppLayerDataBase
import com.br.teste_catho.data.remote.RetrofitConfiguration
import com.br.teste_catho.data.repositories.HomeLocalRepositoryImpl
import com.br.teste_catho.data.repositories.HomeRemoteRepositoryImpl
import com.br.teste_catho.data.repositories.SessionLocalRepositoryImpl
import com.br.teste_catho.data.repositories.SessionRemoteRepositoryImpl
import com.br.teste_catho.domain.datasource.HomeLocalRepository
import com.br.teste_catho.domain.datasource.HomeRemoteRepository
import com.br.teste_catho.domain.datasource.SessionLocalRepository
import com.br.teste_catho.domain.datasource.SessionRemoteRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val repositories = module {

    single { RetrofitConfiguration().getAppRequest() }
    single { DatabaseConfiguration().createDatabase(androidContext()) }

    factory<HomeRemoteRepository> { HomeRemoteRepositoryImpl(get()) }
    factory<SessionRemoteRepository> { SessionRemoteRepositoryImpl(get()) }

    factory<HomeLocalRepository> { (layer: AppLayerDataBase) -> HomeLocalRepositoryImpl(layer.homeDao()) }
    factory<SessionLocalRepository> { (layer: AppLayerDataBase) -> SessionLocalRepositoryImpl(layer.sessionDao()) }
}