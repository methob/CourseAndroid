package com.br.teste_catho.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.br.teste_catho.data.local.entity.SuggestionTb
import com.br.teste_catho.data.local.entity.TipsTb

@Dao
interface HomeDao {
    @Query("SELECT * from tb_suggestion")
    fun retrieveSuggestions() : MutableList<SuggestionTb>?

    @Query("SELECT * from tb_tips")
    fun retrieveUser() : MutableList<TipsTb>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveSuggestions(suggestions : MutableList<SuggestionTb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTips(tips: MutableList<TipsTb>)
}