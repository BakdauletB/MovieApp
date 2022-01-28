package com.example.movie.api

import com.example.movie.data.model.Detail
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IDetailService {

    @GET("3/movie/{id}")
    fun getMovieDetailedAsync(
        @Path(value = "id",
            encoded = true) Id: Int,
        @Query("api_key") apiKey: String,
    ): Deferred<Detail>
}