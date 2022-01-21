package com.example.movie.content.detail.model.repository

import android.app.Application
import com.example.movie.common.remote.ApiConstants
import com.example.movie.common.views.BaseRepository
import com.example.movie.content.detail.model.response.Detail
import com.example.movie.content.list.model.response.PopularResponse
import retrofit2.Response

class DetailRepository(application: Application) : BaseRepository(application) {

    suspend fun getMovieDetail(id: Int) : Response<Detail> = networkService.getDetail(
        id, ApiConstants.API_KEY
    )
}