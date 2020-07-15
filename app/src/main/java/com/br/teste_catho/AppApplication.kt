package com.br.teste_catho

import android.app.Application
import com.br.teste_catho.di.listModules
import org.koin.android.ext.android.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(modules = listModules, context = this)
    }
}