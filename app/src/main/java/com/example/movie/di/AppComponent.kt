package com.example.movie.di

import com.example.movie.presentation.activity.FoundationActivity
import com.example.movie.presentation.character.NewsViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(foundationActivity: FoundationActivity)
}