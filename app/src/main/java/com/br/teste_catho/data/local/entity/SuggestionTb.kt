package com.br.teste_catho.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.br.teste_catho.data.remote.entity.Salary

@Entity(tableName = "tb_suggestion")
data class SuggestionTb (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var jobAdTile : String = "",
    var company : String = "",
    var date : String = "",
    var locations : MutableList<String>? = null,
    @Embedded var salary: Salary? = null
)
