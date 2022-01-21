package com.example.movie.common.remote

import com.example.movie.content.detail.model.response.Detail
import com.example.movie.content.list.model.response.PopularModel
import com.example.movie.content.list.model.response.PopularResponse
import com.example.movie.content.list.model.response.search.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkService {

    @GET(EndPoints.GET_SEARCH)
    suspend fun getSearch(
        @Query("api_key") api_key: String,
        @Query("query") query: String,
        @Query("page") page: String
    ) : Response<SearchResponse>

//    @GET(EndPoints.GET_MOVIE_ID)
//    suspend fun getMovie(
//        @Path("movie_id") movie_id: Int,
//        @Query("api_key") api_key: String,
//    ) : Response<PopularModel>

    @GET(EndPoints.GET_POPULAR)
    suspend fun getMovie(
        @Query("api_key") api_key: String,
        @Query("page") page: Int,
    ) : Response<PopularResponse>
    @GET(EndPoints.GET_MOVIE_ID)
    suspend fun getDetail(
        @Path(value = "id",
        encoded = true) Id:Int,
        @Query("api_key") apiKey: String,
        ) : Response<Detail>

}