package com.br.teste_catho.data.local.source

import com.br.teste_catho.data.remote.entity.Keys
import com.br.teste_catho.data.remote.entity.User

interface SessionLocalDataSource {

    fun getKeys(): Keys?
    fun getUser(): User?
    suspend fun saveKeys(keys: Keys)
    suspend fun saveUser(user: User)

}