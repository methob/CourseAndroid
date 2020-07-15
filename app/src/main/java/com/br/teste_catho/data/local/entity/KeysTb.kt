package com.br.teste_catho.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_keys")
data class KeysTb (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val auth : String = "",
    val tips : String = "",
    val suggestion : String = "",
    val survey : String = ""
)