package com.br.teste_catho.helper

import com.br.teste_catho.data.remote.entity.RemoteError
import com.br.teste_catho.model.ViewError
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import okhttp3.ResponseBody
import retrofit2.HttpException

private val call by lazy { CallError() }

@ExperimentalCoroutinesApi
fun <T> Flow<T>.handleHttpError(block: CallError.() -> Unit): Flow<T> =
    catch { error ->
        when(error) {
            is HttpException -> {
                call.block().apply {
                    error.response()?.errorBody()?.convertToRemoteError()?.let {
                        call.invoke(it.toViewError())
                    }
                }
            } else -> {
                call.block().apply { error.message?.let { call.invoke(ViewError(it)) } }
            }
        }
    }

private fun ResponseBody.convertToRemoteError(): RemoteError {
    val type = object : TypeToken<RemoteError>() {}.type
    return Gson().fromJson(this.charStream(), type)
}

class CallError {
    private var remoteApiError : ((api: ViewError) -> Unit)? = null
    private var genericError : ((error: ViewError) -> Unit)? = null

    //        operator fun invoke(api: RemoteError) { remoteApiError?.invoke(api) }
    operator fun invoke(error: ViewError) {
        genericError?.invoke(error)
        remoteApiError?.invoke(error)
    }

    fun onHttpErrorCall(block: (api: ViewError) -> Unit) { remoteApiError = block }
//        fun onGenericErrorCall(block: (error: ViewError) -> Unit) { genericError = block }
}
