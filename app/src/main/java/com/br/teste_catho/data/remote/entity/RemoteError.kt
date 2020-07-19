package com.br.teste_catho.data.remote.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RemoteError(val status: String, val message: String) : Parcelable