package com.br.teste_catho.data.remote

import com.br.teste_catho.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class RetrofitConfiguration() {

    private fun getRetrofit() =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(OkHttpClient.Builder()
//                    .addInterceptor(HttpInterceptor())
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build())
            .build()

    fun getAppRequest(): AppApi = getRetrofit().create(AppApi::class.java)
}