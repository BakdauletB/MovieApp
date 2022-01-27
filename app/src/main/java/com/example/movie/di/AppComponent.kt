package com.example.movie.di

import com.example.movie.di.modules.AppModule
import com.example.movie.di.modules.NetworkModule
import com.example.movie.presentation.activity.FoundationActivity
import com.example.movie.presentation.movielist.NewsFragment
import com.example.movie.presentation.moviedetail.DetailFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class])
interface AppComponent {

    fun inject(foundationActivity: FoundationActivity)
    fun inject(newsFragment: NewsFragment)
    fun inject(detailFragment: DetailFragment)
}