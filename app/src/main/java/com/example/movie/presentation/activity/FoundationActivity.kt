package com.example.movie.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.movie.App
import com.example.movie.R
import com.example.movie.data.repository.DetailRepository
import com.example.movie.data.repository.NewsRepository
import com.example.movie.presentation.character.NewsViewModel
import com.example.movie.presentation.character.NewsViewModelProviderFactory
import com.example.movie.presentation.detail.DetailViewModel
import com.example.movie.presentation.detail.DetailViewModelProviderFactory
import com.example.movie.utils.base.BaseActivity
import javax.inject.Inject

class FoundationActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: NewsViewModelProviderFactory
    @Inject
    lateinit var viewDetailModelFactory : DetailViewModelProviderFactory


    lateinit var viewModel: NewsViewModel
    lateinit var vm : DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foundation)

        (applicationContext as App).appComponent.inject(this)

        val newsRepository = NewsRepository()
        viewModel = ViewModelProvider(this, viewModelFactory).get(NewsViewModel::class.java)

        val detailRepository = DetailRepository()
        vm = ViewModelProvider(this,viewDetailModelFactory).get(DetailViewModel::class.java)
    }
}