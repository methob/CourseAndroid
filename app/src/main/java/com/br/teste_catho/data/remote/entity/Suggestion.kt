package com.br.teste_catho.data.remote.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Suggestion(var jobAdTile : String = "",
                      var company : String = "",
                      var date : String = "",
                      var locations : MutableList<String>? = null,
                      var salary: Salary? = null): Parcelable