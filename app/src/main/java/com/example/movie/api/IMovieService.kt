package com.example.movie.api

import com.example.movie.data.model.SampleMovieResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface IMovieService {

    @GET("3/movie/popular")
     fun getMovieAsync(
        @Query("api_key") api_key: String,
        @Query("page") page: Int,
    ) : Deferred<SampleMovieResponse>

}