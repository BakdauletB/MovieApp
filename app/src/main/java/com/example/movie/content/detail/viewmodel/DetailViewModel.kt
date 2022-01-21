package com.example.movie.content.detail.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movie.common.remote.ApiConstants
import com.example.movie.content.detail.model.repository.DetailRepository
import com.example.movie.content.detail.model.response.Detail
import com.example.movie.content.list.model.repository.NewsRepository
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = DetailRepository(application)
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