package com.br.teste_catho.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class ErrorResponse

@Parcelize
data class RemoteError(val status: String, val message: String) : Parcelable
object GenericError: ErrorResponse()
object NetworkError: ErrorResponse()