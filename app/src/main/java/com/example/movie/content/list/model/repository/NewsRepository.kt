package com.example.movie.content.list.model.repository

import android.app.Application
import com.example.movie.common.remote.ApiConstants
import com.example.movie.common.views.BaseRepository
import com.example.movie.content.list.model.response.PopularModel
import com.example.movie.content.list.model.response.PopularResponse
import com.example.movie.content.list.model.response.search.SearchResponse
import retrofit2.Response

class NewsRepository(application: Application) : BaseRepository(application) {

//    suspend fun getSearch() : Response<SearchResponse>{
//        return networkService.getSearch(ApiConstants.API_KEY,"Jack Reacher","1")
//    }
    suspend fun getMovie() : Response<PopularResponse> = networkService.getMovie(
        ApiConstants.API_KEY,1
    )

}