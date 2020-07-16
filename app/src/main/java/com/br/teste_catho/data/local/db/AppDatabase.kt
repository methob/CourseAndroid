package com.br.teste_catho.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.br.teste_catho.data.local.entity.KeysTb
import com.br.teste_catho.data.local.entity.SuggestionTb
import com.br.teste_catho.data.local.entity.TipsTb
import com.br.teste_catho.data.local.entity.UserTb

@Database(version = 1, entities = [
    KeysTb::class,
    SuggestionTb::class,
    TipsTb::class,
    UserTb::class
])
abstract class AppLayerDataBase : RoomDatabase() {
    abstract fun sessionDao() : SessionDao
    abstract fun homeDao() : HomeDao
}