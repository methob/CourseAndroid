package com.br.teste_catho.presentation.config

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.br.teste_catho.R
import com.br.teste_catho.data.remote.entity.User
import com.br.teste_catho.databinding.ActivityMainBinding
import com.br.teste_catho.model.ViewStatus
import com.br.teste_catho.presentation.home.HomeActivity
import org.koin.android.viewmodel.ext.android.viewModel

class ConfigActivity : AppCompatActivity() {

    private val viewModel: ConfigViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObserver()
        viewModel.getSessionInfo()
    }

    private fun setupObserver() {
        viewModel.liveDataResponse.observe(this, Observer { status ->
            when (status) {
                is ViewStatus.Success<*> -> {
                    val user = (status.response as User)
                    startActivity(Intent(this, HomeActivity::class.java).apply {
                        putExtra(USER_ARG, user)
                    })
                }
                is ViewStatus.Error -> {
                    binding.animationView.setAnimation(R.raw.error)
                    binding.tvMessage.text = status.response.message
                }
            }
        })
    }

    companion object {
        const val USER_ARG = "USER"
    }
}
