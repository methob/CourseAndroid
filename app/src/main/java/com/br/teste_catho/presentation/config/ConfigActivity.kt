package com.br.teste_catho.presentation.config

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.teste_catho.R
import org.koin.android.viewmodel.ext.android.viewModel

class ConfigActivity : AppCompatActivity() {

    private val viewModel: ConfigViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getSessionInfo()
    }
}
