package com.br.teste_catho.data.repositories

import com.br.teste_catho.data.remote.AppApi
import com.br.teste_catho.domain.datasource.HomeRemoteRepository

open class HomeRemoteRepositoryImpl(private val appApi: AppApi) : HomeRemoteRepository {
}