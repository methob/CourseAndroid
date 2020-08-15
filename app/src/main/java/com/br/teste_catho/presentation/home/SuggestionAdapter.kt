package com.br.teste_catho.presentation.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.br.teste_catho.R
import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.databinding.ItemViewSuggestionCarouselBinding

class SuggestionAdapter() : RecyclerView.Adapter<SuggestionAdapter.SuggestionsViewHolder>() {

    var suggestions = mutableListOf<Suggestion>()

    override fun getItemCount(): Int = suggestions.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionsViewHolder {
        val view = ItemViewSuggestionCarouselBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return SuggestionsViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: SuggestionsViewHolder, position: Int) {
       holder.onBind(suggestions[position])
    }

    inner class SuggestionsViewHolder(private val binding: ItemViewSuggestionCarouselBinding,
                                      private val context: Context)
        : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(suggestion: Suggestion) {
            binding.tvJobTitle.text = suggestion.jobAdTile
            binding.tvDate.text = suggestion.date
            binding.tvCompany.text = suggestion.company
            binding.tvVacancies.text = "${suggestion.locations?.size} vagas - ${suggestion.locations?.get(0)}"
            binding.tvSalary.text = suggestion.salary?.range
            binding.btnToggleSalary.setOnClickListener {
                if (binding.tvSalary.isVisible) {
                    binding.btnToggleSalary.setColorFilter(ContextCompat.getColor(context, R.color.SteelBlue))
                } else {
                    binding.btnToggleSalary.setColorFilter(ContextCompat.getColor(context, R.color.SlateGray))
                }
                binding.tvSalary.isInvisible = !binding.tvSalary.isInvisible
            }
        }
    }
}