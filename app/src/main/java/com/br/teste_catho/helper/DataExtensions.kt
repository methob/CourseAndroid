package com.br.teste_catho.helper

import com.br.teste_catho.model.GenericError
import com.br.teste_catho.model.RemoteError
import com.br.teste_catho.presentation.config.BaseViewModel.CallError
import com.google.gson.Gson
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
                        call.invoke(it)
                    }
                }
            } else -> {
                call.block().apply {
                    call.invoke(GenericError)
                }
            }
        }
    }

private fun ResponseBody.convertToRemoteError(): RemoteError {
    val adapter = Gson().getAdapter(RemoteError::class.java)
    return adapter.fromJson(this.toString())
}

