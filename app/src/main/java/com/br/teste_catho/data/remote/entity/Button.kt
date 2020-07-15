package com.br.teste_catho.data.remote.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Button(val show : String = "",
                  val label : String = "",
                  val url : String = ""): Parcelable