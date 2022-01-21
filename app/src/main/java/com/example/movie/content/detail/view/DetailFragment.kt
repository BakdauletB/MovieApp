package com.example.movie.content.detail.view

import android.os.Bundle
import android.view.View
import com.example.movie.R
import com.example.movie.common.views.BaseFragment
import com.example.movie.common.views.viewBinding
import androidx.activity.addCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.movie.common.remote.ApiConstants
import com.example.movie.common.utils.setImage
import com.example.movie.content.detail.model.response.Detail
import com.example.movie.content.detail.viewmodel.DetailViewModel
import com.example.movie.content.list.viewmodel.MovieNewsViewModel
import com.example.movie.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.loadingViews
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailFragment : BaseFragment(R.layout.fragment_detail) {

    private lateinit var viewModel: DetailViewModel
    private val binding by viewBinding(FragmentDetailBinding::bind)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this){
            navigateTo(R.id.newsFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lets()
    }

    private fun lets() {
        initViewModel()
        initListeners()
        setDetail()
        initObservers()


    }

    private fun initListeners() {
        toolbar.setOnClickListener {
            navigateTo(R.id.newsFragment)
        }
    }

    private fun setDetail() {
        arguments?.getInt("id")?.let {
            setLoading(true)
            viewModel.fetchMovieById(it)
        }
    }

    private fun initObservers() {
        viewModel.movieDetail.observe(viewLifecycleOwner,{
            setLoading(false)
            setData(it)
        })
    }

    private fun setData(detail: Detail) {
        image.setImage(detail.posterPath)
        title.text = detail.title
        release.text = detail.releaseDate
        overview.text = detail.overview

    }


    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]

    }
    private fun setLoading(loading: Boolean) {
        loadingViews.visibility = if (loading) View.VISIBLE else View.GONE

    }


}