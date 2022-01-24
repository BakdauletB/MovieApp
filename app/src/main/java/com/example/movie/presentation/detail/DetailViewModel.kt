package com.example.movie.presentation.detail


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie.remote.ApiConstants
import com.example.movie.data.repository.DetailRepository
import com.example.movie.data.model.Detail
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: DetailRepository) : ViewModel() {

    var movieDetail = MutableLiveData<Detail>()

    fun fetchMovieById(id :Int){
        viewModelScope.launch {
            val response = repository.getMovieDetail(id)
            when( response.code()){
                ApiConstants.RESPONSE_SUCCESS_CODE -> movieDetail.postValue(response.body()!!)

            }
        }
    }
}