package com.br.teste_catho.data.remote.source

import com.br.teste_catho.data.remote.entity.Keys
import com.br.teste_catho.data.remote.entity.User

interface SessionRemoteDataSource {

    suspend fun getKeys(): Keys
    suspend fun getUser(): User
}