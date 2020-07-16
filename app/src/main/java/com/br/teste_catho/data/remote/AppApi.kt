package com.br.teste_catho.data.remote

import com.br.teste_catho.BuildConfig
import com.br.teste_catho.data.remote.entity.Keys
import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.data.remote.entity.Tips
import com.br.teste_catho.data.remote.entity.User
import retrofit2.http.GET
import retrofit2.http.Path

interface AppApi {

    @GET("keys")
    suspend fun getKeys(): Keys

    @GET("auth/{user_id}")
    suspend fun getUser(@Path("user_id") userId: String = BuildConfig.USER_ID): User

    @GET("suggestion")
    suspend fun getSuggestions()
            : MutableList<Suggestion>

    @GET("tips")
    suspend fun getTips(): MutableList<Tips>

}