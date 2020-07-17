package com.br.teste_catho.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class  HttpInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val baseUrl = chain.request()
        val urlWithQuery = baseUrl.newBuilder()
            .build()
        val concatenatedUrl = chain.request().newBuilder().url("").build()
        return chain.proceed(concatenatedUrl)
    }
}