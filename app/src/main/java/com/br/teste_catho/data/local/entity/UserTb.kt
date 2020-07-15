package com.br.teste_catho.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_keys")
data class UserTb (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name : String = "",
    val token : String = "",
    val photo : String = ""
)