package com.br.teste_catho.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_tips")
data class TipsTb (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)