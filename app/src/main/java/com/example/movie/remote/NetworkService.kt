package com.example.movie.remote

import com.example.movie.data.model.Detail
import com.example.movie.data.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkService {



//    @GET(EndPoints.GET_MOVIE_ID)
//    suspend fun getMovie(
//        @Path("movie_id") movie_id: Int,
//        @Query("api_key") api_key: String,
//    ) : Response<MovieModel>

    @GET(EndPoints.GET_POPULAR)
    suspend fun getMovie(
        @Query("api_key") api_key: String,
        @Query("page") page: Int,
    ) : Response<MovieResponse>
    @GET(EndPoints.GET_MOVIE_ID)
    suspend fun getDetail(
        @Path(value = "id",
        encoded = true) Id:Int,
        @Query("api_key") apiKey: String,
        ) : Response<Detail>

}