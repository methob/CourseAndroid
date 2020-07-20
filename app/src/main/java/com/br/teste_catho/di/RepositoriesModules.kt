package com.br.teste_catho.di

import com.br.teste_catho.data.local.DatabaseConfiguration
import com.br.teste_catho.data.local.db.AppLayerDataBase
import com.br.teste_catho.data.local.source.HomeLocalDataSource
import com.br.teste_catho.data.local.source.HomeLocalDataSourceImpl
import com.br.teste_catho.data.local.source.SessionLocalDataSource
import com.br.teste_catho.data.local.source.SessionLocalDataSourceImpl
import com.br.teste_catho.data.remote.HttpInterceptor
import com.br.teste_catho.data.remote.RetrofitConfiguration
import com.br.teste_catho.data.remote.source.HomeRemoteDataSource
import com.br.teste_catho.data.remote.source.HomeRemoteDataSourceImpl
import com.br.teste_catho.data.remote.source.SessionRemoteDataSource
import com.br.teste_catho.data.remote.source.SessionRemoteDataSourceImpl
import com.br.teste_catho.data.repositories.HomeRepositoryImpl
import com.br.teste_catho.data.repositories.SessionRepositoryImpl
import com.br.teste_catho.domain.repository.HomeRepository
import com.br.teste_catho.domain.repository.SessionRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val repositories = module {

    single { DatabaseConfiguration().createDatabase(androidContext()) }
    single { HttpInterceptor(get()) }
    single { RetrofitConfiguration(get()).getAppRequest() }

    factory<HomeLocalDataSource> { HomeLocalDataSourceImpl(get<AppLayerDataBase>().homeDao() ) }
    factory<HomeRemoteDataSource> { HomeRemoteDataSourceImpl(get()) }
    factory<HomeRepository> { HomeRepositoryImpl(get(), get()) }

    factory<SessionLocalDataSource> { SessionLocalDataSourceImpl(get<AppLayerDataBase>().sessionDao()) }
    factory<SessionRemoteDataSource> { SessionRemoteDataSourceImpl(get()) }
    factory<SessionRepository> { SessionRepositoryImpl(get(), get()) }
}