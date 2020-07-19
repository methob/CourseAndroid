package com.br.teste_catho.data.remote

import com.br.teste_catho.data.local.source.SessionLocalDataSource
import com.br.teste_catho.data.remote.entity.Tips
import com.br.teste_catho.data.remote.helper.SetAuthHeader
import com.br.teste_catho.data.remote.helper.SetKeyHeader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation

class HttpInterceptor(private val dataSource: SessionLocalDataSource) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val invocation = chain.request().tag(Invocation::class.java)
        val builder = chain.request().newBuilder()
        invocation?.method()?.annotations?.let { annotations ->
            annotations.forEach { annotation ->
                when(annotation.annotationClass) {
                    SetAuthHeader::class -> {
                        getAuthKey()?.let {
                            builder.addHeader(authorizationKey, it)
                        }
                    }
                    SetKeyHeader::class -> {
                        getOptKey((annotation as SetKeyHeader).value)?.let {
                           builder.addHeader(apiKey, it)
                        }
                    }
                }
            }
        }

        return chain.proceed(builder.build())
    }

    private fun getAuthKey(): String? = dataSource.getUser()?.token

    private  fun getOptKey(key:String): String? {
        val keys = dataSource.getKeys()
        return when(key){
            AUTH -> keys?.auth
            SUGGESTION -> keys?.suggestion
            TIPS -> keys?.tips
            else -> null
        }
    }

    companion object HeaderUtils {
        const val apiKey = "x-api-key"
        const val authorizationKey = "Authorization"
        const val AUTH = "auth"
        const val SUGGESTION = "suggestion"
        const val TIPS = "tips"
    }
}