package com.example.movie.presentation.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movie.data.repository.DetailRepository
import com.example.movie.data.repository.NewsRepository

class NewsViewModelProviderFactory(
    val newsRepository: NewsRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }

}