package com.example.movie.data.repository

import android.app.Application
import com.example.movie.remote.ApiConstants
import com.example.movie.utils.base.BaseRepository
import com.example.movie.data.model.Detail
import retrofit2.Response

class DetailRepository() : BaseRepository() {

    suspend fun getMovieDetail(id: Int) : Response<Detail> = networkService.getDetail(
        id, ApiConstants.API_KEY
    )
}