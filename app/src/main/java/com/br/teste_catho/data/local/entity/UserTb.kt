package com.br.teste_catho.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_user")
data class UserTb (
    @PrimaryKey()
    var id: String = "",
    var name : String = "",
    var token : String = "",
    var photo : String = ""
)