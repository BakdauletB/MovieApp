package com.example.movie.presentation.movielist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie.Resources
import com.example.movie.data.model.Results
import com.example.movie.data.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {

    var movieList = MutableLiveData<List<Results>>()
    var page = 1
    fun getNewsList() {
        viewModelScope.launch {
            val response = repository.getMovieData(page)
            when (response.status) {
                Resources.Status.SUCCESS -> {
                    response.data?.let {
                        movieList.value = it.results
                    }
                }
                else -> {
                    }
            }
        }
    }
}


































