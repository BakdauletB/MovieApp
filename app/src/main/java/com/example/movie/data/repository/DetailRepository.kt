package com.example.movie.data.repository

import com.example.movie.Resources
import com.example.movie.api.IDetailService
import com.example.movie.ApiConstants
import com.example.movie.data.model.Detail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailRepository @Inject constructor(private val movieDetail: IDetailService) {

    suspend fun fetchMovieById(id: Int) :
        Resources<Detail> {
        return withContext(Dispatchers.IO){
            val response = movieDetail.getMovieDetailedAsync(id,apiKey = ApiConstants.API_KEY).await()
                Resources.success(response)
        }
    }

}