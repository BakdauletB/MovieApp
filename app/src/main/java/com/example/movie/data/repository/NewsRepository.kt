package com.example.movie.data.repository

import android.app.Application
import com.example.movie.data.model.MovieResponse
import com.example.movie.remote.ApiConstants
import com.example.movie.utils.base.BaseRepository
import retrofit2.Response


class NewsRepository() : BaseRepository() {


    suspend fun getMovie() : Response<MovieResponse> = networkService.getMovie(
        ApiConstants.API_KEY,1
    )

}