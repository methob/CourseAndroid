package com.br.teste_catho.data.remote.source

import com.br.teste_catho.data.remote.AppApi
import com.br.teste_catho.data.remote.entity.Keys
import com.br.teste_catho.data.remote.entity.User

class SessionRemoteDataSourceImpl(private val appApi: AppApi) : SessionRemoteDataSource {

    override suspend fun getKeys(): Keys = appApi.getKeys()
    override suspend fun getUser(): User = appApi.getUser()

}