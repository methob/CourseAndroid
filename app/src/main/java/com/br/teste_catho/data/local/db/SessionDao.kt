package com.br.teste_catho.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.br.teste_catho.data.local.entity.KeysTb
import com.br.teste_catho.data.local.entity.UserTb

@Dao
interface SessionDao {

    @Query("SELECT * from tb_keys")
    fun retrieveKeys() : KeysTb?

    @Query("SELECT * from tb_user")
    fun retrieveUser() : UserTb?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveKeys(keys : KeysTb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(user : UserTb)

}