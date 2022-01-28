package com.example.movie.presentation.character

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie.App
import com.example.movie.data.model.MovieModel
import com.example.movie.remote.ApiConstants
import com.example.movie.data.repository.NewsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {


//    val newsList: MutableLiveData<List<MovieModel>> = MutableLiveData()
    private val isUpdateApp = MutableLiveData<Boolean>()
    private val isUnAuthorized = MutableLiveData<Boolean>()
    private val isError: MutableLiveData<String> = MutableLiveData()
     val liveDataList: MutableLiveData<List<MovieModel>> = MutableLiveData()

    fun getNewsList() {
        viewModelScope.launch {
            try {
                val response = repository.getMovie()
                when (response.code()) {
                    ApiConstants.RESPONSE_SUCCESS_CODE -> liveDataList.postValue(response.body()!!.results)
                    ApiConstants.RESPONSE_UPDATE_APP -> isUpdateApp.postValue(true)
                    ApiConstants.RESPONSE_UNAUTHORIZED -> isUnAuthorized.postValue(true)
                    else -> isError.postValue(null)
                }
            } catch (e: Exception) {
                isError.postValue(null)
            }

        }
    }











//    fun getLiveDataObserver() : MutableLiveData<MovieResponse> {
//        return liveDataList
//    }
//     fun makeApicall(){
//        val call : Call<MovieResponse>? = mService.getMovie(ApiConstants.API_KEY,1)
//        call?.enqueue(object: Callback<MovieResponse>{
//            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//                liveDataList.postValue(null)
//            }
//
//            override fun onResponse(
//                call: Call<MovieResponse>,
//                response: Response<MovieResponse>
//            ) {
//                if(response.isSuccessful) {
//                    liveDataList.postValue(response.body())
//                } else {
//                    liveDataList.postValue(null)
//                }
//            }
//        })
//    }

















}