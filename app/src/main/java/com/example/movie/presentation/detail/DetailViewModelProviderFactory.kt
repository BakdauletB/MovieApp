package com.example.movie.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movie.data.repository.DetailRepository
import com.example.movie.presentation.character.NewsViewModel

class DetailViewModelProviderFactory(
    val detailRepository: DetailRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(detailRepository) as T

    }
}