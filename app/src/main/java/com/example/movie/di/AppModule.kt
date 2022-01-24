package com.example.movie.di

import android.app.Application
import android.content.Context
import com.example.movie.data.repository.DetailRepository
import com.example.movie.data.repository.NewsRepository
import com.example.movie.presentation.character.NewsViewModelProviderFactory
import com.example.movie.presentation.detail.DetailViewModelProviderFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideApp(): Application {
        return Application()
    }

    @Provides
    fun provideContext() : Context {
        return context
    }

    @Provides
    fun provideNewsRepository(): NewsRepository {
        return NewsRepository()
    }
    @Provides
    fun provideDetailRepository() : DetailRepository {
        return DetailRepository()
    }

    @Provides
    fun provideNewsViewModelFactory(
        newsRepository: NewsRepository
    ) : NewsViewModelProviderFactory {
        return NewsViewModelProviderFactory(
            newsRepository = newsRepository)
    }
    @Provides
    fun provideDetailViewModelFactory(
        detailRepository: DetailRepository
    ) : DetailViewModelProviderFactory {
        return  DetailViewModelProviderFactory(
            detailRepository = detailRepository)
    }



}