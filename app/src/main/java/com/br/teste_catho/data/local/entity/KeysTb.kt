package com.br.teste_catho.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_keys")
data class KeysTb (
    @PrimaryKey
    var id: Int = 1,
    var auth : String = "",
    var tips : String = "",
    var suggestion : String = "",
    var survey : String = ""
)