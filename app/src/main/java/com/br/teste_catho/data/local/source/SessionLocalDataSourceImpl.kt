package com.br.teste_catho.data.local.source

import com.br.teste_catho.data.local.db.SessionDao
import com.br.teste_catho.data.local.mapper.convertToKeysTB
import com.br.teste_catho.data.local.mapper.convertToKeysModel
import com.br.teste_catho.data.local.mapper.convertToUserModel
import com.br.teste_catho.data.local.mapper.convertToUserTB
import com.br.teste_catho.data.remote.entity.Keys
import com.br.teste_catho.data.remote.entity.User

class SessionLocalDataSourceImpl(private val sessionDao: SessionDao) : SessionLocalDataSource {

    override fun getKeys(): Keys? = sessionDao.retrieveKeys()?.convertToKeysModel()

    override fun getUser(): User? = sessionDao.retrieveUser()?.convertToUserModel()

    override suspend fun saveKeys(keys: Keys) = sessionDao.saveKeys(keys.convertToKeysTB())

    override suspend fun saveUser(user: User) = sessionDao.saveUser(user.convertToUserTB())

}