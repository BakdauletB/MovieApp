package com.example.movie.presentation.moviedetail


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie.Resources
import com.example.movie.data.repository.DetailRepository
import com.example.movie.data.model.Detail
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: DetailRepository) : ViewModel() {

    var movieDetail = MutableLiveData<Detail>()

    fun fetchMovieById(id :Int){
        viewModelScope.launch {
            val response = repository.fetchMovieById(id)
            when (response.status) {
                Resources.Status.SUCCESS -> {
                    response.data?.let {
                        movieDetail.value = it
                    }
                }
                else -> {
                }
            }
        }
    }
}