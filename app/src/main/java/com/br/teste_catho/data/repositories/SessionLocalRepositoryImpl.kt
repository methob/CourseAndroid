package com.br.teste_catho.data.repositories

import com.br.teste_catho.data.local.db.SessionDao
import com.br.teste_catho.domain.datasource.SessionLocalRepository

class SessionLocalRepositoryImpl(private val homeDao: SessionDao) : SessionLocalRepository {
}