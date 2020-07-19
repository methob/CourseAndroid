package com.br.teste_catho.data.remote.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(var id : String = "",
                var name : String = "",
                var token : String = "",
                var photo : String = ""): Parcelable