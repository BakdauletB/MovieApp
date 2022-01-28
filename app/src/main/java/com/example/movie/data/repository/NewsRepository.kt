package com.example.movie.data.repository

import android.util.Log
import com.example.movie.Resources
import com.example.movie.api.IMovieService
import com.example.movie.data.model.SampleMovieResponse
import com.example.movie.ApiConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class NewsRepository  @Inject constructor(private val movieService: IMovieService) {

     suspend fun getMovieData(page: Int) :
            Resources<SampleMovieResponse> {
         return withContext(Dispatchers.IO) {
                 val response = movieService.getMovieAsync(ApiConstants.API_KEY, page).await()
                 Resources.success(response)
         }
    }

}