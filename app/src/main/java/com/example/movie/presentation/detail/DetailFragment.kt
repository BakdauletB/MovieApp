package com.example.movie.presentation.detail

import android.os.Bundle
import android.view.View
import com.example.movie.R
import com.example.movie.utils.base.BaseFragment
import androidx.activity.addCallback
import com.example.movie.utils.setImage
import com.example.movie.data.model.Detail
import com.example.movie.presentation.activity.FoundationActivity
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.loadingViews

class DetailFragment : BaseFragment(R.layout.fragment_detail) {

    private lateinit var vm: DetailViewModel
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
            vm.fetchMovieById(it)
        }
    }

    private fun initObservers() {
        vm.movieDetail.observe(viewLifecycleOwner,{
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
        vm = (activity as FoundationActivity).vm

    }
    private fun setLoading(loading: Boolean) {
        loadingViews.visibility = if (loading) View.VISIBLE else View.GONE

    }


}