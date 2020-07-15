package com.br.teste_catho.data.remote.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Keys(val auth : String = "",
                val tips : String = "",
                val suggestion : String = "",
                val survey : String = ""): Parcelable