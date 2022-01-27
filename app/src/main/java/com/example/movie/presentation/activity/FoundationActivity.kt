package com.example.movie.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.movie.App
import com.example.movie.R
import com.example.movie.data.repository.DetailRepository
import com.example.movie.api.IDetailService
import com.example.movie.api.IMovieService
import com.example.movie.data.repository.NewsRepository
import com.example.movie.presentation.movielist.NewsViewModel
import com.example.movie.presentation.movielist.NewsViewModelProviderFactory
import com.example.movie.presentation.moviedetail.DetailViewModel
import com.example.movie.presentation.moviedetail.DetailViewModelProviderFactory
import javax.inject.Inject

class FoundationActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: NewsViewModelProviderFactory
    @Inject
    lateinit var viewDetailModelFactory : DetailViewModelProviderFactory
    @Inject
    lateinit var iMovieService: IMovieService
    @Inject
    lateinit var iDetailService: IDetailService


    lateinit var viewModel: NewsViewModel
    lateinit var vm : DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foundation)

        (applicationContext as App).appComponent.inject(this)

        val newsRepository = NewsRepository(iMovieService)
        viewModel = ViewModelProvider(this, viewModelFactory).get(NewsViewModel::class.java)

        val detailRepository = DetailRepository(iDetailService)
        vm = ViewModelProvider(this,viewDetailModelFactory).get(DetailViewModel::class.java)
    }
}