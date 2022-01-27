package com.example.movie.di.modules

import com.example.movie.api.IDetailService
import com.example.movie.api.IMovieService
import com.example.movie.ApiConstants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Bakdaulet Batyrkhan on 26/1/2022
 */

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttp: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(logger)

        return Retrofit.Builder()
            .baseUrl(ApiConstants.API_URL)
            .client(okHttp.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    @Provides
    fun provideMovieInterface(retrofit: Retrofit) : IMovieService {
        return retrofit.create(IMovieService::class.java)
    }
    @Provides
    fun provideMovieDetailInterface(retrofit: Retrofit) : IDetailService {
        return retrofit.create(IDetailService::class.java)
    }

}