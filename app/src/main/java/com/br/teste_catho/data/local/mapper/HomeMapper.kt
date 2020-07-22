package com.br.teste_catho.data.local.mapper

import com.br.teste_catho.data.local.entity.SuggestionTb
import com.br.teste_catho.data.remote.entity.Suggestion

fun MutableList<SuggestionTb>?.convertToListSuggestionsModel() = mutableListOf<Suggestion>().apply {
        this@convertToListSuggestionsModel?.forEach { suggestionTb ->
            this.add(Suggestion().apply {
                jobAdTile = suggestionTb.jobAdTile
                company = suggestionTb.company
                date = suggestionTb.date
                locations = suggestionTb.locations
                salary = suggestionTb.salary
            })
        }
    }


fun MutableList<Suggestion>.convertToListSuggestionsTb() = mutableListOf<SuggestionTb>().apply {
    this@convertToListSuggestionsTb?.forEach { suggestion ->
        this.add(SuggestionTb().apply {
            jobAdTile = suggestion.jobAdTile
            company = suggestion.company
            date = suggestion.date
            locations = suggestion.locations
            salary = suggestion.salary
        })
    }
}

