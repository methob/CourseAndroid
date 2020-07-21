package com.br.teste_catho.presentation.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.databinding.ItemViewSuggestionCarouselBinding

class SuggestionAdapter() : RecyclerView.Adapter<SuggestionAdapter.SuggestionsViewHolder>() {

    var suggestions = ArrayList<Suggestion>()

    override fun getItemCount(): Int = suggestions.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionsViewHolder {
        val view = ItemViewSuggestionCarouselBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return SuggestionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuggestionsViewHolder, position: Int) {
       holder.onBind(suggestions[position])
    }

    inner class SuggestionsViewHolder(private val binding: ItemViewSuggestionCarouselBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun onBind(suggestion: Suggestion) {
            when (suggestion.jobAdTile) {
                "A" -> {
                    binding.cardBora.setCardBackgroundColor(Color.RED)
                }
                "B" -> {
                    binding.cardBora.setCardBackgroundColor(Color.BLACK)
                }
                else -> {
                    binding.cardBora.setCardBackgroundColor(Color.WHITE)
                }
            }
        }
    }
}