package com.br.teste_catho.data.remote.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Suggestion(val jobAdTile : String = "",
                      val company : String = "",
                      val date : String = "",
                      val locations : MutableList<String>? = null,
                      val salary: Salary? = null): Parcelable