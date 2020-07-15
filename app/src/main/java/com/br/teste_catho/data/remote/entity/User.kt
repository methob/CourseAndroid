package com.br.teste_catho.data.remote.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val id : String = "",
                val name : String = "",
                val token : String = "",
                val photo : String = ""): Parcelable