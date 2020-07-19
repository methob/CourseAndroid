package com.br.teste_catho.data.local

import android.content.Context
import androidx.room.Room
import com.br.teste_catho.data.local.db.AppLayerDataBase

class DatabaseConfiguration {
    fun createDatabase(context: Context) : AppLayerDataBase {
        return Room
            .databaseBuilder(context, AppLayerDataBase::class.java,"JonathanApp.db")
            .allowMainThreadQueries()
            .build()
    }
}