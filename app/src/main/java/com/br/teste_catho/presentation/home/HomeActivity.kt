package com.br.teste_catho.presentation.home

import android.content.Context
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: ActivityHomeBinding
    private val pageAdapter by lazy { SuggestionAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        pageAdapter.suggestions = arrayListOf(Suggestion(jobAdTile = "A"),
            Suggestion(jobAdTile = "B"), Suggestion(jobAdTile = "C"))
        binding.vpSuggestions.adapter = pageAdapter
        TabLayoutMediator(binding.tabDots, binding.vpSuggestions) { _, _ -> }.attach()
        configureViewPage()
    }

    private fun configureViewPage() {
        binding.vpSuggestions.offscreenPageLimit = 1

        val nextItemVisiblePx = 60f
        val currentItemHorizontalMarginPx = 60f
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
          page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
        }
        binding.vpSuggestions.setPageTransformer(pageTransformer)
        binding.vpSuggestions.addItemDecoration(HorizontalMarginItemDecoration(this))
    }

    class HorizontalMarginItemDecoration(context: Context) :
        RecyclerView.ItemDecoration() {

        private val horizontalMarginInPx: Int = 70

        override fun getItemOffsets(
            outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
        ) {
            outRect.right = horizontalMarginInPx
            outRect.left = horizontalMarginInPx
        }

    }
}
