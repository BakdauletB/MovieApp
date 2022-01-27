package com.example.movie.di.modules

import android.app.Application
import android.content.Context
import com.example.movie.data.repository.DetailRepository
import com.example.movie.api.IDetailService
import com.example.movie.api.IMovieService
import com.example.movie.data.repository.NewsRepository
import com.example.movie.presentation.movielist.NewsViewModelProviderFactory
import com.example.movie.presentation.moviedetail.DetailViewModelProviderFactory
import dagger.Module
import dagger.Provides


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
    fun provideNewsRepository(iMovieService: IMovieService): NewsRepository {
        return NewsRepository(iMovieService)
    }
    @Provides
    fun provideDetailRepository(iDetailService: IDetailService) : DetailRepository {
        return DetailRepository(iDetailService)
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