package com.br.teste_catho.presentation.home

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import coil.api.load
import coil.transform.CircleCropTransformation
import com.br.teste_catho.BuildConfig
import com.br.teste_catho.R
import com.br.teste_catho.data.remote.entity.Suggestion
import com.br.teste_catho.data.remote.entity.User
import com.br.teste_catho.databinding.ActivityHomeBinding
import com.br.teste_catho.model.Success
import com.br.teste_catho.model.ViewStatus
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
        setupObservers()
        viewModel.getSuggestion()
    }

    private fun setupObservers() {
        viewModel.liveDataResponse.observe(this, Observer { status ->
            when(status) {
                is Success<MutableList<Suggestion>> -> {
                    val suggestions = status.response
                    pageAdapter.suggestions = suggestions
                    binding.vpSuggestions.adapter = pageAdapter
                    TabLayoutMediator(binding.tabDots, binding.vpSuggestions) { _, _ -> }.attach()
                }
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun setupViews() {
        configureViewPage()
        intent.getParcelableExtra<User>(USER_ARG)?.let {
            binding.imgUserPhoto
                .load(BuildConfig.BASE_URL + it.photo.drop(DROP_FIRST_CHARACTER)) {
                    placeholder(R.mipmap.ic_launcher)
                    transformations(CircleCropTransformation())
                }
            binding.tvUserName.text = "Olá, ${it.name}"
        }
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

    companion object {
        const val USER_ARG = "USER"
        const val DROP_FIRST_CHARACTER = 1
    }
}
