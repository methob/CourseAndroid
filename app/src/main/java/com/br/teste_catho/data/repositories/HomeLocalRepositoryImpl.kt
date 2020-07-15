package com.br.teste_catho.data.repositories

import com.br.teste_catho.data.local.db.HomeDao
import com.br.teste_catho.domain.datasource.HomeLocalRepository

class HomeLocalRepositoryImpl(private val sessionDao: HomeDao) : HomeLocalRepository {

}