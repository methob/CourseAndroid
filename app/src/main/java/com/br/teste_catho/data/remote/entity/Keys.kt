package com.br.teste_catho.data.remote.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Keys(var auth : String = "",
                var tips : String = "",
                var suggestion : String = "",
                var survey : String = ""): Parcelable