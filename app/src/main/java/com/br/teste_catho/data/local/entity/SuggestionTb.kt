package com.br.teste_catho.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_suggestion")
data class SuggestionTb (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)
