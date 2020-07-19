package com.br.teste_catho.data.remote

import com.br.teste_catho.BuildConfig
import com.br.teste_catho.data.remote.entity.Keys
import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.data.remote.entity.Tips
import com.br.teste_catho.data.remote.entity.User
import com.br.teste_catho.data.remote.helper.SetAuthHeader
import com.br.teste_catho.data.remote.helper.SetKeyHeader
import retrofit2.http.*

interface AppApi {

    @GET("keys")
    suspend fun getKeys(): Keys

    @GET("auth/{user_id}")
    @SetKeyHeader("auth")
    suspend fun getUser(@Path("user_id") userId: String = BuildConfig.USER_ID): User

    @GET("suggestion")
    @SetKeyHeader("suggestion")
    @SetAuthHeader
    suspend fun getSuggestions(): MutableList<Suggestion>

    @GET("tips")
    @SetKeyHeader("tips")
    suspend fun getTips(): MutableList<Tips>

}