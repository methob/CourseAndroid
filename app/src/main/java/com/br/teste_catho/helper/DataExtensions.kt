package com.br.teste_catho.helper

import com.br.teste_catho.data.remote.entity.RemoteError
import com.br.teste_catho.model.ViewError
import com.br.teste_catho.presentation.config.BaseViewModel.CallError
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

