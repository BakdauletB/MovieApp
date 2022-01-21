package com.example.movie.content.list.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movie.common.remote.ApiConstants
import com.example.movie.content.list.model.repository.NewsRepository
import com.example.movie.content.list.model.response.PopularModel
import com.example.movie.content.list.model.response.PopularResponse
import kotlinx.coroutines.launch

class MovieNewsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = NewsRepository(application)
    val newsList: MutableLiveData<List<PopularModel>> = MutableLiveData()



    val isUpdateApp = MutableLiveData<Boolean>()
    val isUnAuthorized = MutableLiveData<Boolean>()
    val isError: MutableLiveData<String> = MutableLiveData()

    fun getNewsList() {
        viewModelScope.launch {
            try {
                val response = repository.getMovie()
                Log.d("response","${response.body()!!.results}")

                when (response.code()) {
                    ApiConstants.RESPONSE_SUCCESS_CODE -> newsList.postValue(response.body()!!.results)
                    ApiConstants.RESPONSE_UPDATE_APP -> isUpdateApp.postValue(true)
                    ApiConstants.RESPONSE_UNAUTHORIZED -> isUnAuthorized.postValue(true)
                    else -> isError.postValue(null)
                }
            } catch (e: Exception) {
                isError.postValue(null)
            }

        }
    }
}