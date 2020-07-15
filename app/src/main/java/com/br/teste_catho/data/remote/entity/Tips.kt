package com.br.teste_catho.data.remote.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tips(val id : String = "",
                val description : String = "",
                val token : String = "",
                val button: Button? = null): Parcelable